layui.use(['table','laytpl','util'],function(){
    var $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //用户列表
    table.render({
        elem: '#logList',
        url : '/log/rms/list_log',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "logListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth:80},
            {field: 'account', title: '用户名', align:'center',minWidth:100},
            {field: 'type', title: '用户类型', align:'center',minWidth:100, templet:function(d){
                    return d.type === 0 ? "用户" : "管理员";
                }},
            {field: 'ip', title: '登录IP', align:'center',minWidth:150},
            {field: 'address', title: '登录地址', align:'center'},
            {field: 'result', title: '登录结果', align:'center',minWidth:120,templet:function(d){
                    if(d.result === 0){
                        return "<span style=\"color: #25f585;\">登录成功</span>";
                    }else if(d.result === 1){
                        return "<span style=\"color: #ffa692;\">用户不存在</span>";
                    }
                    return "<span style=\"color: #ff5461;\">密码错误</span>";
                }},
            {field: 'time', title: '登录时间', align:'center',width:170,templet:function(d){
                    {{ return util.toDateString(d.time, 'yyyy-MM-dd HH:mm:ss')}}
                }}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("logListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                account: $(".searchAccount").val(),  //搜索的关键字
                type: $("#type").val(),
                result: $("#result").val()
            }
        })
    });
});
