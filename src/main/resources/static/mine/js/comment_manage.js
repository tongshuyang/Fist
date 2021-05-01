layui.use(['form','layer','table','util'],function(){
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //评论列表
    table.render({
        elem: '#commentList',
        url : '/comment/rms/list_comment',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "commentListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth: 80},
            {field: 'movingId', title: '动态ID', align:'center',minWidth: 80},
            {field: 'userId', title: '用户ID', align:'center',minWidth: 80},
            {field: 'content', title: '内容', align:'center',minWidth: 300},
            {field: 'state', title: '状态', align:'center',minWidth: 100, templet:function(d){
                    if(d.state === 0){
                        return "<span style=\"color: #ffb22a;\">未审核</span>";
                    }else if(d.state === 1){
                        return "<span style=\"color: #25f585;\">审核成功</span>";
                    }
                    return "<span style=\"color: #F581B1;\">审核失败</span>";
                }},
            {field: 'createTime', title: '发送时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {title: '操作', templet:'#commentListBar',fixed:"right",align:"center",width:120}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("commentListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                userId: $(".searchUserId").val(),  //搜索的关键字
                movingId: $(".searchMovingId").val(),
                state: $("#state").val()
            }
        })
    });

    //列表操作
    table.on('tool(commentList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'pass'){
            if(data.state === 1){
                layer.msg("已通过的评论", {time: 2000});
            }else {
                $.get("/comment/rms/pass_comment",{id : data.id},function(res){
                    if(res.rs){
                        table.reload("commentListTable");
                    }
                    layer.msg(res.info, {time: 2000});
                })
            }
        }else if(layEvent === 'ban'){
            if(data.state === 2){
                layer.msg("已屏蔽的评论", {time: 2000});
            }else {
                $.get("/comment/rms/ban_comment",{id : data.id},function(res){
                    if(res.rs){
                        table.reload("commentListTable");
                    }
                    layer.msg(res.info, {time: 2000});
                })
            }
        }
    });
});
