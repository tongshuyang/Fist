layui.use(['table','laytpl','util'],function(){
    var $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //用户列表
    table.render({
        elem: '#visitsList',
        url : '/visits/rms/list_visits',
        height : "full-20",
        limits : [10,20,30],
        limit : 20,
        id : "visitsListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth:80},
            {field: 'date', title: '日期', align:'center',minWidth:150, templet:function(d){
                    {{ return util.toDateString(d.date, 'yyyy-MM-dd')}}
            }},
            {field: 'daily', title: '日访问量', align:'center',minWidth:150},
            {field: 'count', title: '总访问量', align:'center',minWidth:150}
        ]]
    });
});
