layui.use(['form','layer','table','util'],function(){
    var layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //动态列表
    table.render({
        elem: '#adminUserList',
        url : '/admin_user/rms/list_admin_user',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "adminUserListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center",minWidth: 80},
            {field: 'username', title: '用户名', align:'center',minWidth: 120},
            {field: 'role', title: '角色', align:'center',minWidth: 120,templet:function(d){
                    if(d.role === 0){
                        return "超级无敌管理员";
                    }
                    return "普通管理员";
                }},
            {field: 'isBan', title: '禁用', align:'center',minWidth: 80,templet:function(d){
                    if(d.isBan === 0){
                        return "<span style=\"color: #25f585;\">否</span>";
                    }
                    return "<span style=\"color: #F581B1;\">是</span>";
                }},
            {field: 'createTime', title: '发布时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {field: 'updateTime', title: '更新时间', align:'center',minWidth: 170,templet:function(d){
                    {{ return util.toDateString(d.updateTime, 'yyyy-MM-dd HH:mm:ss')}}
                }},
            {title: '操作', templet:'#adminUserListBar',fixed:"right",align:"center",width:120}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("adminUserListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                username: $(".searchUsername").val()
            }
        })
    });

    //打开弹框
    function openDialog(){
        layer.open({
            title : "编辑后台用户",
            type : 2,
            area : ["316px","242px"],
            content : '/admin_user/rms/edit_admin_user_dialog'
        });
    }

    //添加
    $(".add_btn").on("click",function(){
        window.rowdata = undefined;
        openDialog()
    });

    //操作
    table.on('tool(adminUserList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        window.rowdata = data;
        if(data.role === 0){
            layer.msg('此处不能操作超级管理员', {time: 2000});
        }else if(layEvent === 'alt'){
            openDialog()
        }else if(layEvent === 'ban'){
            $.get("/admin_user/rms/ban_admin_user",{id : data.id,isBan : data.isBan },function(res){
                if(res.rs){
                    table.reload('adminUserListTable');
                }
                layer.close(index);
                layer.msg(res.info, {time: 2000});
            })
        }

    });
});
