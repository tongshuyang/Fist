layui.use(['form','layer','table','util'],function(){
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //动态列表
    table.render({
        elem: '#serviceList',
        url : '/service/rms/list_service',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "serviceListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth: 80},
            {field: 'name', title: '服务名称', align:'center',minWidth: 100},
            {field: 'sketch', title: '服务简述', align:'center',minWidth: 120},
            {field: 'content', title: '服务内容', align:'center',minWidth: 200},
            {field: 'img', title: '封面图', align:'center',minWidth: 100},
            {field: 'imgLeft', title: '封面图左', align:'center',minWidth: 100},
            {field: 'sort', title: '排序', align:'center',minWidth: 80},
            {field: 'createTime', title: '发布时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {field: 'updateTime', title: '更新时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.updateTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {title: '操作', templet:'#serviceListBar',fixed:"right",align:"center",width:120}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("serviceListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                name: $(".searchName").val()
            }
        })
    });

    //打开弹框
    function openDialog(){
        layer.open({
            title : "修改服务",
            type : 2,
            area : ["100%","100%"],
            content : '/service/rms/edit_service_dialog'
        });
    }
    //添加
    $(".add_btn").on("click",function(){
        window.rowdata = undefined;
        openDialog()
    });

    //操作
    table.on('tool(serviceList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        window.rowdata = data;
        if(layEvent === 'alt'){
            openDialog()
        }else if(layEvent === 'del'){
            layer.confirm('确定删除此服务？',{icon:3, title:'提示信息'},function(index){
                $.get("/service/rms/del_service",{id : data.id},function(res){
                    if(res.rs){
                        table.reload('serviceListTable');
                    }
                    layer.close(index);
                    layer.msg(res.info, {time: 2000});
                })
            });
        }
    });
});
