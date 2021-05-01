<!DOCTYPE html>
<html lang="en">
<head>
    <title>修改友链</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/mine/rms/css/public.css">
</head>
<body class="childrenBody">
<form class="layui-form altForm" lay-filter="editForm">
    <div class="layui-form-item">
        <input type="hidden" name="id">
    </div>
    <div class="layui-form-item">
        <input type="hidden" name="logo" id="logo">
    </div>
    <div class="layui-form-item">
        <div id="upload" class="layui-upload-list imgBox">
            <img id="show_logo" class="layui-upload-img uploadImg">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">网站名</label>
        <div class="layui-input-block">
            <input type="text" name="name" class="layui-input" lay-verify="required" placeholder="请输入网站名" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">网站地址</label>
        <div class="layui-input-block">
            <input type="text" name="link" class="layui-input" lay-verify="required|url" placeholder="请输入网站地址" />
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">站长邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" class="layui-input" lay-verify="required|email" placeholder="请输入站长邮箱" />
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
            upload = layui.upload,
            form = layui.form;

        var formUrl = '/friend_link/rms/alt_link';
        if(parent.rowdata === undefined){
            formUrl = '/friend_link/rms/add_link'
        }else {
            //赋初值
            form.val('editForm', $.extend(true,{},parent.rowdata));
            var logoVal= $('#logo').val();
            if(logoVal !== '' && logoVal !== undefined){
                $('#show_logo').attr('src','${conf.img_url!}' + logoVal);
            }
        }

        //表单提交事件
        form.on('submit(editSubmit)', function(data){
            layer.closeAll();
            $.post(formUrl,data.field,function (res) {
                if(res.rs){
                    parent.location.href = "/friend_link/rms/link_manage"
                }
                layer.msg(res.info, {time: 2000});
            });
            return false;
        });

        //上传图片
        upload.render({
            elem: '#upload',
            url: '/friend_link/rms/upload_logo',
            done: function(res){
                if(res.rs){
                    $('#show_logo').attr('src','${conf.img_url!}' + res.data);
                    document.getElementById("logo").value = res.data;
                }else {
                    layer.msg(res.info);
                }
            }
            ,size: ${conf.maxUpload!} //最大允许上传的文件大小
        })
    })
</script>
</body>
</html>