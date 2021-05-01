layui.use(['form','layer','table','laytpl','util'],function(){
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        util = layui.util,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : '/user/rms/list_user',
        height : "full-106",
        limits : [10,20,30],
        limit : 20,
        id : "userListTable",
        page : true,
        cols : [[
            {field: 'id', title: 'ID', align:"center"},
            {field: 'name', title: '姓名', align:'center',width:80},
            {field: 'phone', title: '手机号', align:'center',width:120},
            {field: 'nick', title: '昵称', align:'center',width:80},
            {field: 'sex', title: '性别', align:'center', templet:function(d){
                return d.sex === 0 ? "女" : "男";
            }},
            {field: 'birthday', title: '生日', align:'center',width:110,templet:function(d){
                {{ return util.toDateString(d.birthday, 'yyyy-MM-dd')}}
            }},
            {field: 'job', title: '工作', align:'center',width:100},
            {field: 'carType', title: '车型', align:'center',width:100},
            {field: 'licensePlate', title: '车牌号', align:'center',width:120},
            {field: 'address', title: '地址', align:'center',width:120},
            {field: 'memberPoints', title: '积分', align:'center',width:80},
            {field: 'isDel', title: '是否注销',  align:'center',width:100,templet:function(d){
                return d.isDel === 0 ? "否" : "<span style=\"color: #F581B1;\">是</span>";
            }},
            {field: 'createTime', title: '注册时间', align:'center',width:160,templet:function(d){
                {{ return util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}
            }},
            {field: 'updateTime', title: '修改时间', align:'center',width:160,templet:function(d){
                {{ return util.toDateString(d.updateTime, 'yyyy-MM-dd HH:mm:ss')}}
            }},
            {title: '操作', templet:'#userListBar',fixed:"right",align:"center",width:170}
        ]]
    });

    //搜索
    $(".search_btn").on("click",function(){
        table.reload("userListTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                id: $(".searchId").val(),  //搜索的关键字
                phone: $(".searchPhone").val(),
                name: $(".searchName").val(),
                licensePlate: $(".searchLicensePlate").val(),
                isDel: $("#isDel").val()
            }
        })
    });

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'integral'){
            layer.prompt({title: '修改积分', formType: 0, value: data.memberPoints}, function(memberPoints){
                $.post("/user/rms/alt_member_points",{id: data.id,memberPoints: memberPoints},function (res) {
                    if(res.rs){
                        table.reload("userListTable");
                    }
                    layer.closeAll();
                    layer.msg(res.info, {time: 2000});
                });
            });
        }else if(layEvent === 'notice'){
            layer.prompt({formType: 2, title: '发送通知'}, function(content){
                $.post("/notice/rms/send_notice",{userId: data.id,content: content},function (res) {
                    layer.closeAll();
                    layer.msg(res.info, {time: 2000});
                });
            });
        }else if(layEvent === 'del'){
            layer.confirm('确定注销此用户？',{icon:3, title:'提示信息'},function(index){
                if(data.isDel === 1){
                    layer.msg("已是注销用户", {time: 2000});
                }else {
                    $.get("/user/rms/del_user",{id : data.id},function(res){
                        if(res.rs){
                            tableIns.reload();
                        }
                        layer.close(index);
                        layer.msg(res.info, {time: 2000});
                    })
                }
            });
        }
    });
});
