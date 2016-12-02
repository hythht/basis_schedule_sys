$(document).ready(function() {

    // $.ajax({
    //     url:"/queryTaskList.do",
    //     type:"get",
    //     dataType:"json",
    //     success:function (data) {
    //         alert("success "+data.toString());
    //     },
    //     error:function (data) {
    //         alert("fail "+data.toString());
    //     }
    // });

    // dom元素：
    // l - Length changing 每页显示多少条数据选项
    // f - Filtering input 搜索框
    // t - The Table 表格
    // i - Information 表格信息
    // p - Pagination 分页按钮
    // r - pRocessing 加载等待显示信息
    // < and > - div elements 一个div元素
    // <"#id" and > - div with an id 指定id的div元素
    // <"class" and > - div with a class 指定样式名的div元素
    // <"#id.class" and > - div with an id and class 指定id和样式的div元素
    //H - jQueryUI'header'classes,<H *>将jQueryUI皮肤（头部）应用到*
    //F - jQueryUI'footer'classes,<F *>将jQueryUI皮肤（脚部）应用到*
    var taskTableparam=createDataTableCommonParam("/queryTaskList.do");
    taskTableparam.dom='<"H"<"toolbar"> Blfr  > t <"F"ip >';
    taskTableparam.aoColumns=[
        {"mDataProp":"task_id"},
        {"mDataProp":"name"},
        {"mDataProp":"des"},
        {"mDataProp":"taskclassname"},
        {"mDataProp":"type"},
        {"mDataProp":"para"},
        {"mDataProp":"prior"},
        {"mDataProp":"cost"},
        {"mDataProp":"avg_cost"}
    ];
    taskTableparam.buttons=[
        {
            extend:"copy",
            text:'复制'
        },{
            extend:"print",
            text:'打印'
        }
    ];
     $('#taskTable').DataTable(taskTableparam);

    $("div.toolbar").html('<b style="color:red">自定义文字、图片等等</b>');
});
