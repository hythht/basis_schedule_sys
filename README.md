# 基本调度系统，用于各种测试用和收集的工具方法
注意事项：
1增加数据库操作步骤：
    1 在model包内新增数据类型，可以为输入参数的数据结构或者结果的数据结构
    2 在myabtis-config.xml内添加别名
    例子：<typeAlias alias="Task" type="model.Task"/>
    3 在mapper文件夹内增加*-mapper.xml
    模板参考test-mapper.xml
    空间命名规则为<mapper namespace="mapperNS.Test">，其中Test为自定义
    4 在utils中Constants中添加，MAPPER_*变量，赋值为*-mapper.xml中的命名空间
    5 在Dao包中建立*Dao类，提供与数据库进行交互的接口
    Dao中，执行sql需要调用之前在Constants中添加的MAPPER_*变量
 注意事项：
    1 mapper.xml里面，大小写需要转义：
    &lt;    <   小于号
    &gt;    >   大于号
    &amp;   &   和
    &apos;  ’   单引号
    &quot;  "   双引号

2获取xml配置文件信息，xml配置文件需要放置在resources的config文件夹下
    增加系统变量步骤如下：
    1 在Constants中添加变量，设置未初始化值（null/-1）
    2 在system-property.xml中添加property
    3 修改Constants中initSystemProperties方法，增加初始化
    4 在Constants中添加获取变量方法（含校验）

 3想要获取自动注入的bean（即注释的类如service,DAO等）可通过
 WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
 获取当前上下文，再由上文中调用
 context.getBeanNamesForType(*.class)获取同类型的所有bean名字
 再通过bean名字获取bean的实体
 (*) context.getBean(String BeanName)







