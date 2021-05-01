<!DOCTYPE html>
<html lang="en">
<head>
    <title>修改通知</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
</head>
<body class="childrenBody">
<form class="layui-form" lay-filter="altForm" style="padding: 15px">
    <div class="layui-form-item">
        <input type="hidden" name="id">
    </div>
    <div class="layui-form-item">
        <input type="text" name="title" lay-verify="required" placeholder="请输入标题" class="layui-input title">
    </div>
    <div class="layui-form-item">
        <input type="text" name="content" lay-verify="required" placeholder="请输入内容" class="layui-input content">
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" lay-filter="altSubmit" lay-submit>立即提交</button>
    </div>
</form>
<script type="text/javascript" src="/static/layui/layui.js"></script>
<script>
    layui.use('form',function(){
        var layer = parent.layer,
            $ = layui.$,
            form = layui.form;

        //赋初值
        form.val('altForm', $.extend(true,{},parent.rowdata));
        //表单提交事件
        form.on('submit(altSubmit)', function(data){
            layer.closeAll();
            $.post("/notice/rms/alt_notice",data.field,function (res) {
                if(res.rs){
                    parent.location.href = "/notice/rms/notice_manage"
                }
                layer.msg(res.info, {time: 2000});
            });
            return false;
        });
    })
</script>
</body>
</html>