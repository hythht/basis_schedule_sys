package basisSchedule.tablesDao;

import basisSchedule.resultModel.Task_List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import utils.Constants;
import utils.LogUtil;

import java.util.List;


@Repository
public class Task_ListDao {

    @Autowired ()
    @Qualifier( "schedulesqlSessionTemplate" )
    private SqlSessionTemplate sqlSessionSchedule;

    /*
    查询所有列表中所有任务
     */
    public List<Task_List> query(){
        return sqlSessionSchedule.selectList(Constants.MAPPER_TASK_LIST+".queryTask_List");
    }

    /*
    往任务列表插入任务
     */
    public int insert(Task_List task_list){
        try {
            sqlSessionSchedule.insert(Constants.MAPPER_TASK_LIST + ".insertTask_List", task_list);
            LogUtil.SuccessLogAdd(
                    Constants.LOG_INFO,
                    "任务列表 " + task_list.getTask_id(), "插入", true);
            return Constants.SUCCESS;
        } catch (DuplicateKeyException e) {
            LogUtil.ErrorLogAdd(
                     Constants.LOG_ERROR
                    , "任务列表 " + task_list.getTask_id(), "插入", "键值重复", true);
            return Constants.DUPLICATEKEYERROR;
        } catch (DataIntegrityViolationException e) {
            LogUtil.ErrorLogAdd(
                    Constants.LOG_ERROR
                    , "任务列表 " + task_list.getTask_id(), "插入", "违反完整性约束", true);
            return Constants.DATAVIOLATIONERROR;
        } catch (Exception e) {
            //e.printStackTrace();
            LogUtil.ErrorLogAdd(
                    Constants.LOG_ERROR
                    , "任务列表 " + task_list.getTask_id(), "插入", "其他原因", true);
            return Constants.UNKNOWNERROR;
        }
    }

    //删除任务信息
    public int  delete(int task_id) {
        try {
            sqlSessionSchedule.delete(Constants.MAPPER_TASK_LIST + ".deleteTask_ListById", task_id);
            LogUtil.SuccessLogAdd(
                    Constants.LOG_INFO,
                    "任务列表 task_id" + task_id, "删除",true);
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.ErrorLogAdd(
                    Constants.LOG_ERROR,
                    "任务列表 task_id" + task_id, "删除", "未知原因",true);
            return Constants.FAIL;
        }
    }

    //更新任务列表任务状态，根据TaskList
    public int updateTaskListByTask_List(Task_List task_list){
        int result=Constants.FAIL;
        try {
            result=sqlSessionSchedule.update(Constants.MAPPER_TASK_LIST + ".updateTaskListByTask_List",task_list);
            LogUtil.SuccessLogAdd(
                    Constants.LOG_INFO,
                    "方法 updateTaskListByTask_List ", "执行",true);
            return Constants.SUCCESS;
        } catch (Exception e) {
            LogUtil.ErrorLogAdd(
                    Constants.LOG_ERROR,
                    "方法 updateTaskListByTask_List ", "执行", "未知原因",true);
            return result;
        }
    }
}
