layui.use(['layer','table','laytpl','util'],function(){
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //配置列表渲染
    table.render({
        elem: '#confList',
        url : '/conf/list_conf/verify',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "confListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",width:60},
            {field: 'key', title: '键', align:'center',width:100},
            {field: 'value', title: '值', align:'center',minWidth:200},
            {field: 'remark', title: '备注', align:'center',minWidth:200},
            {field: 'updateTime', title: '修改时间', align:'center',width:170,templet:function(d){
                    {{ return util.toDateString(d.updateTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {title: '操作', templet:'#confListBar',fixed:"right",align:"center",width:80}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("confListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                remark: $(".searchRemark").val()  //搜索的关键字
            }
        })
    });

    //列表操作
    table.on('tool(confList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'alt'){
            layer.prompt({title: '修改值', formType: 2, value: data.value}, function(value){
                $.post("/conf/alt_conf/verify",{id: data.id,value: value},function (res) {
                    if(res.rs){
                        table.reload("confListTable");
                    }
                    layer.closeAll();
                    layer.msg(res.info, {time: 2000});
                });
            });
        }
    });
});
