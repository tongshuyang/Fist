<!DOCTYPE html>
<html lang="en">
<head>
    <title>编辑动态</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/mine/rms/css/public.css">
</head>
<body class="childrenBody">
<form class="layui-form layui-row layui-col-space10 altForm" lay-filter="editForm">
    <div class="layui-col-sm12 layui-col-xs12">
        <div class="layui-row layui-col-space10">
            <div class="layui-col-sm9 layui-col-xs12">
                <div class="layui-form-item">
                    <input type="hidden" name="id">
                </div>
                <div class="layui-form-item">
                    <input type="hidden" name="creator" id="creator">
                </div>
                <div class="layui-form-item magt3">
                    <label class="layui-form-label">标　题</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" class="layui-input" lay-verify="required" placeholder="请输入文章标题">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">分　类</label>
                    <div class="layui-input-block">
                        <select name="type" lay-verify="required">
                            <option value="0">优惠活动</option>
                            <option value="1">爱车知识</option>
                            <option value="2">通知公告</option>
                            <option value="3">本店招聘</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">状　态</label>
                    <div class="layui-input-block">
                        <select name="state" lay-verify="required">
                            <option value="0">显示</option>
                            <option value="1">不显示</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">置　顶</label>
                    <div class="layui-input-block">
                        <select name="isStick" lay-verify="required">
                            <option value="0">否</option>
                            <option value="1">是</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm3 layui-col-xs12">
                <div class="layui-form-item">
                    <input type="hidden" name="coverUrl" id="coverUrl" lay-verify="required" disabled>
                </div>
                <div id="upload" class="layui-upload-list thumbBox mag0 magt3">
                    <img id="showImg" class="layui-upload-img thumbImg">
                </div>
            </div>
        </div>
        <div class="layui-form-item magb0">
            <label class="layui-form-label">文章内容</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea layui-hide" name="content" lay-verify="content|required" id="moving_content"></textarea>
            </div>
        </div>
    </div>
    <div class="layui-right">
        <a class="layui-btn layui-btn-sm" lay-filter="editSubmit" lay-submit><i class="layui-icon">&#xe609;</i>发布</a>
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

        var formUrl = '/moving/rms/alt_moving';
        if(parent.rowdata === undefined){
            $('#creator').attr('value','${adminUser.username!}');
            formUrl = '/moving/rms/add_moving'
        }else {
            //赋初值
            form.val('editForm', $.extend(true,{},parent.rowdata));
            var coverUrl = $('#coverUrl').val();
            if(coverUrl !== '' && coverUrl !== undefined){
                $('#showImg').attr('src','${conf.img_url!}' + coverUrl);
            }
        }

        //创建一个编辑器
        var editIndex = layedit.build('moving_content',{
            height : 350,
            uploadImage : {
                url : "/moving/rms/upload_edit_img"
            }
        });

        //表单提交事件
        form.on('submit(editSubmit)', function(data){
            layer.closeAll();
            $.post(formUrl,data.field,function (res) {
                if(res.rs){
                    parent.location.href = "/moving/rms/moving_manage"
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
            elem: '#upload',
            url: '/moving/rms/upload_moving',
            done: function(res){
                if(res.rs){
                    $('#showImg').attr('src','${conf.img_url!}' + res.data);
                    document.getElementById("coverUrl").value = res.data;
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