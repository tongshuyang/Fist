<!DOCTYPE html>
<html lang="en">
<head>
    <title>编辑动态</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/mine/css/public.css">
</head>
<body class="childrenBody">
<form class="layui-form layui-row layui-col-space10 altForm" lay-filter="editForm">
    <div class="layui-col-sm12 layui-col-xs12">
        <div class="layui-row layui-col-space10">
            <div class="layui-col-sm6 layui-col-xs12">
                <div class="layui-form-item">
                    <input type="hidden" name="id">
                </div>
                <div class="layui-form-item magt3">
                    <label class="layui-form-label">服务名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" class="layui-input" lay-verify="required" placeholder="请输入服务名">
                    </div>
                </div>
                <div class="layui-form-item magt3">
                    <label class="layui-form-label">简 述</label>
                    <div class="layui-input-block">
                        <textarea name="sketch" class="layui-textarea" lay-verify="required" placeholder="请输入服务简述"></textarea>
                    </div>
                </div>
                <div class="layui-form-item magt3">
                    <label class="layui-form-label">排 序</label>
                    <div class="layui-input-block">
                        <input type="number" name="sort" class="layui-input" lay-verify="required" placeholder="请输入排序">
                    </div>
                </div>
            </div>
            <div class="layui-col-sm3 layui-col-xs12">
                <div class="layui-form-item">
                    <input type="hidden" name="img" id="img" lay-verify="required" disabled>
                </div>
                <div id="uploadImg" class="layui-upload-list thumbBox mag0 magt3">
                    <img id="showImg" class="layui-upload-img thumbImg">
                </div>
            </div>
            <div class="layui-col-sm3 layui-col-xs12">
                <div class="layui-form-item">
                    <input type="hidden" name="imgLeft" id="imgLeft" lay-verify="required" disabled>
                </div>
                <div id="uploadImgLeft" class="layui-upload-list thumbBox mag0 magt3">
                    <img id="showImgLeft" class="layui-upload-img thumbImg">
                </div>
            </div>
        </div>
        <div class="layui-form-item magb0">
            <label class="layui-form-label">服务内容</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea layui-hide" name="content" lay-verify="content|required" id="service_content"></textarea>
            </div>
        </div>
    </div>
    <div class="layui-right">
        <a class="layui-btn layui-btn-sm" lay-filter="editSubmit" lay-submit><i class="layui-icon layui-icon-component"></i> 提 交</a>
    </div>
</form>
<script type="text/javascript" src="/static/layui/layui.js"></script>
<script>
    layui.use(['form','layedit','upload'],function(){
        var layer = parent.layer,
            $ = layui.$,
            layedit = layui.layedit,
            upload = layui.upload,
            form = layui.form;

        var formUrl = '/service/rms/alt_service';
        if(parent.rowdata === undefined){
            formUrl = '/service/rms/add_service'
        }else {
            //赋初值
            form.val('editForm', $.extend(true,{},parent.rowdata));
            var img = $('#img').val();
            if(img !== '' && img !== undefined){
                $('#showImg').attr('src','${conf.img_url!}' + img);
            }
            var imgLeft = $('#imgLeft').val();
            if(imgLeft !== '' && imgLeft !== undefined){
                $('#showImgLeft').attr('src','${conf.img_url!}' + imgLeft);
            }
        }

        //创建一个编辑器
        var editIndex = layedit.build('service_content',{
            height : 350,
            uploadImage : {
                url : "/service/rms/upload_edit_img"
            }
        });

        //表单提交事件
        form.on('submit(editSubmit)', function(data){
            layer.closeAll();
            $.post(formUrl,data.field,function (res) {
                if(res.rs){
                    parent.location.href = "/service/rms/service_manage"
                }
                layer.msg(res.info, {time: 2000});
            });
            return false;
        });

        form.verify({
            content: function(){
                //用于同步编辑器内容到textarea
                layedit.sync(editIndex);
            }
        });

        //上传封面
        upload.render({
            elem: '#uploadImg',
            url: '/service/rms/upload_service',
            done: function(res){
                if(res.rs){
                    $('#showImg').attr('src','${conf.img_url!}' + res.data);
                    document.getElementById("img").value = res.data;
                }else {
                    layer.msg(res.info);
                }
            }
            ,size: ${conf.maxUpload!} //最大允许上传的文件大小
        });

        //上传封面左
        upload.render({
            elem: '#uploadImgLeft',
            url: '/service/rms/upload_service',
            done: function(res){
                if(res.rs){
                    $('#showImgLeft').attr('src','${conf.img_url!}' + res.data);
                    document.getElementById("imgLeft").value = res.data;
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