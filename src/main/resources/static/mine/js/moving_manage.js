layui.use(['form','layer','table','util'],function(){
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //动态列表
    table.render({
        elem: '#movingList',
        url : '/moving/rms/list_moving',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "movingListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth: 80},
            {field: 'title', title: '动态标题', align:'center',minWidth: 120},
            {field: 'coverUrl', title: '封面图路径', align:'center',minWidth: 120},
            {field: 'content', title: '动态内容', align:'center',minWidth: 200},
            {field: 'type', title: '动态类型', align:'center',minWidth: 100, templet:function(d){
                switch (d.type) {
                    case 0:
                        return "优惠活动";
                    case 1:
                        return "爱车知识";
                    case 2:
                        return "通知公告";
                    case 3:
                        return "本店招聘";
                }
            }},
            {field: 'state', title: '状态', align:'center',minWidth: 80, templet:function(d){
                    if(d.state === 0){
                        return "<span style=\"color: #25f585;\">显示</span>";
                    }else if(d.state === 1){
                        return "<span style=\"color: #ffa692;\">不显示</span>";
                    }
                    return "<span style=\"color: #ff5461;\">已删除</span>";
                }},
            {field: 'isStick', title: '置顶', align:'center',minWidth: 80, templet:function(d){
                    if(d.isStick === 0){
                        return "否";
                    }
                        return "<span style=\"color: #0000dc;\">是</span>";
                }},
            {field: 'creator', title: '发布人', align:'center',minWidth: 100},
            {field: 'createTime', title: '发布时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {field: 'updateTime', title: '更新时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.updateTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {title: '操作', templet:'#movingListBar',fixed:"right",align:"center",width:120}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("movingListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                title: $(".searchTitle").val(),
                state: $("#state").val(),
                type: $("#type").val()
            }
        })
    });
    //打开弹框
    function openDialog(){
        layer.open({
            title : "修改动态",
            type : 2,
            area : ["100%","100%"],
            content : '/moving/rms/edit_moving_dialog'
        });
    }
    //添加
    $(".add_btn").on("click",function(){
        window.rowdata = undefined;
        openDialog()
    });

    //操作
    table.on('tool(movingList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        window.rowdata = data;
        if(layEvent === 'alt'){
            openDialog()
        }else if(layEvent === 'del'){
            layer.confirm('确定删除此动态？',{icon:3, title:'提示信息'},function(index){
                if(data.state === 2){
                    layer.msg("已是删除状态", {time: 2000});
                }else {
                    $.get("/moving/rms/del_moving",{id : data.id},function(res){
                        if(res.rs){
                            table.reload('movingListTable');
                        }
                        layer.close(index);
                        layer.msg(res.info, {time: 2000});
                    })
                }
            });
        }
    });
});
