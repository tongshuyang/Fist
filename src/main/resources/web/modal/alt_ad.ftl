<!DOCTYPE html>
<html lang="en">
<head>
    <title>修改广告</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/mine/rms/css/public.css">
</head>
<body class="childrenBody">
<form class="layui-form altForm" lay-filter="altForm">
    <div class="layui-form-item">
        <input type="hidden" name="id">
    </div>
    <div class="layui-form-item">
        <div id="upload" class="layui-upload-list imgBox">
            <img id="show_ad" class="layui-upload-img uploadImg">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">保存路径</label>
        <div class="layui-input-block">
            <input type="text" name="url" id="url" class="layui-input layui-disabled" lay-verify="required" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">跳转链接</label>
        <div class="layui-input-block">
            <input type="text" name="link" class="layui-input" lay-verify="required" placeholder="请输入跳转链接"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图片描述</label>
        <div class="layui-input-block">
            <input type="text" name="alt" class="layui-input" lay-verify="required" placeholder="请输入图片描述" />
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" lay-filter="altSubmit" lay-submit>立即提交</button>
    </div>
</form>
<script type="text/javascript" src="/static/layui/layui.js"></script>
<script>
    layui.use(['form','upload'],function(){
        var layer = parent.layer,
            $ = layui.$,
            upload = layui.upload,
            form = layui.form;

        //赋初值
        form.val('altForm', $.extend(true,{},parent.rowdata));

        var url = $('#url').val()
        if(url !== '' && url !== undefined){
            $('#show_ad').attr('src','${conf.img_url!}' + url);
        }
        //表单提交事件
        form.on('submit(altSubmit)', function(data){
            layer.closeAll();
            $.post("/ad/rms/alt_ad",data.field,function (res) {
                if(res.rs){
                    parent.location.href = "/ad/rms/ad_manage"
                }
                layer.msg(res.info, {time: 2000});
            });
            return false;
        });

        //上传图片
        upload.render({
            elem: '#upload',
            url: '/ad/rms/upload_ad',
            done: function(res){
                if(res.rs){
                    $('#show_avatar').attr('src','${conf.img_url!}' + res.data);
                    document.getElementById("url").value = res.data;
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