<!DOCTYPE html>
<html lang="en">
<head>
    <title>编辑用户</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/mine/css/public.css">
</head>
<body class="childrenBody">
<form class="layui-form altForm" lay-filter="editForm">
    <div class="layui-form-item">
        <input type="hidden" name="id">
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" class="layui-input" lay-verify="required" placeholder="请输入用户名"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密 码</label>
        <div class="layui-input-block">
            <input type="password" name="password" class="layui-input" lay-verify="pwd" placeholder="请输入密码" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" class="layui-input" lay-verify="required" placeholder="请输入姓名"/>
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" lay-filter="editSubmit" lay-submit>立即提交</button>
    </div>
</form>
<script type="text/javascript" src="/static/layui/layui.js"></script>
<script>
    layui.use(['form','upload'],function(){
        var layer = parent.layer,
            $ = layui.$,
            form = layui.form;

        var formUrl = '/user/alt_user/verify';
        if(parent.rowdata === undefined){
            formUrl = '/user/add_user/verify'
        }else {
            //赋初值
            form.val('editForm', $.extend(true,{},parent.rowdata));
        }

        //表单提交事件
        form.on('submit(editSubmit)', function(data){
            layer.closeAll();
            $.post(formUrl,data.field,function (res) {
                if(res.rs){
                    parent.location.href = "/user/user_manage_view/verify"
                }
                layer.msg(res.info, {time: 2000});
            });
            return false;
        });

        form.verify({
            pwd: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });
    })
</script>
</body>
</html>