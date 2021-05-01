layui.use(['form','layer','table','util'],function(){
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //评论列表
    table.render({
        elem: '#leaveWordList',
        url : '/leave_word/rms/list_leave_word',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "leaveWordListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth: 80},
            {field: 'userId', title: '用户ID', align:'center',minWidth: 80},
            {field: 'name', title: '姓名', align:'center',minWidth: 80},
            {field: 'sex', title: '性别', align:'center',minWidth: 80,templet:function(d){
                    if(d.sex === 0){
                        return "女";
                    }
                    return "男";
            }},
            {field: 'phone', title: '手机号', align:'center',minWidth: 120},
            {field: 'email', title: '邮箱', align:'center',minWidth: 100,templet:function(d){
                    return "<a href = 'mailto:"+d.email+"'>"+d.email+"</a>"
                }},
            {field: 'content', title: '留言内容', align:'center',minWidth: 200},
            {field: 'state', title: '状态', align:'center',minWidth: 100, templet:function(d){
                    if(d.state === 0){
                        return "<span style=\"color: #ffb22a;\">未查看</span>";
                    }else if(d.state === 1){
                        return "<span style=\"color: #25f585;\">已查看</span>";
                    }
                    return "<span style=\"color: #F581B1;\">已删除</span>";
                }},
            {field: 'createTime', title: '留言时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}
            }},
            {title: '操作', templet:'#leaveWordListBar',fixed:"right",align:"center",width:120}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("leaveWordListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                name: $(".searchName").val(),  //搜索的关键字
                phone: $(".searchPhone").val(),
                state: $("#state").val()
            }
        })
    });

    //列表操作
    table.on('tool(leaveWordList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'view'){
            if(data.state === 1){
                layer.msg("已查看的留言", {time: 2000});
            }else {
                $.get("/leave_word/rms/view_leave_word",{id : data.id},function(res){
                    if(res.rs){
                        table.reload("leaveWordListTable");
                    }
                    layer.msg(res.info, {time: 2000});
                })
            }
        }else if(layEvent === 'del'){
            $.get("/leave_word/rms/del_leave_word",{id : data.id},function(res){
                if(res.rs){
                    table.reload("leaveWordListTable");
                }
                layer.msg(res.info, {time: 2000});
            })
        }
    });
});
