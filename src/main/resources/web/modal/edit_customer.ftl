<!DOCTYPE html>
<html lang="en">
<head>
    <title>编辑客户</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link rel="stylesheet" href="/static/mine/css/public.css">
</head>
<body class="childrenBody">
<form class="layui-form layui-row layui-col-space10 altForm" lay-filter="editForm">
    <div class="layui-col-sm12 layui-col-xs12">
        <div class="layui-row layui-col-space10">
            <div class="layui-form-item">
                <input type="hidden" name="id">
            </div>
            <div class="layui-col-sm4 layui-col-xs12">
                <div class="layui-form-item magt3 layui-col-sm12 layui-col-xs12">
                    <label class="layui-form-label">公司名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="companyName" class="layui-input" lay-verify="required" placeholder="请输入公司名称">
                    </div>
                </div>
                <div class="layui-form-item magt3">
                    <label class="layui-form-label">所属销售</label>
                    <div class="layui-input-block">
                        <input type="text" name="saleName" class="layui-input" lay-verify="required" placeholder="请输入销售名称">
                    </div>
                </div>
            </div>
            <div class="layui-col-sm4 layui-col-xs12">
                <div class="layui-form-item">
                    <label class="layui-form-label">区 域</label>
                    <div class="layui-input-block">
                        <select name="area" lay-verify="required">、
                            <option value="0">未分类</option>
                            <option value="1">华东</option>
                            <option value="2">华南</option>
                            <option value="3">华北</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">是否签约</label>
                    <div class="layui-input-block">
                        <select name="isSigned" lay-verify="required">
                            <option value="0">未签约</option>
                            <option value="1">已签约</option>
                            <option value="2">待续签</option>
                            <option value="3">待回款</option>
                            <option value="4">未续签</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm4 layui-col-xs12">
                <div class="layui-form-item">
                    <label class="layui-form-label">等 级</label>
                    <div class="layui-input-block">
                        <select name="level" lay-verify="required">
                            <option value="0">小体量</option>
                            <option value="1">中等</option>
                            <option value="2">重要</option>
                            <option value="3">非常重要</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">对接进度</label>
                    <div class="layui-input-block">
                        <select name="buttProgress" lay-verify="required">
                            <option value="0">了解产品</option>
                            <option value="1">首次对接中</option>
                            <option value="2">对接完成</option>
                            <option value="3">升级版本</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-form-item magb0">
            <label class="layui-form-label">对接方式</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" name="buttType" lay-verify="required"></textarea>
            </div>
        </div>
        <div class="layui-form-item magb0">
            <label class="layui-form-label">公司详情</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea layui-hide" name="companyDetail" lay-verify="sync|required" id="company_detail"></textarea>
            </div>
        </div>
    </div>
    <div class="layui-right">
        <a class="layui-btn layui-btn-sm" lay-filter="editSubmit" lay-submit><i class="layui-icon">&#xe609;</i>提交</a>
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

        var formUrl = '/customer/alt_customer/verify';
        if(parent.rowdata === undefined){
            formUrl = '/customer/add_customer/verify'
        }else {
            //表单赋初值
            form.val('editForm', $.extend(true,{},parent.rowdata));
        }

        //创建富文本编辑器
        var editIndex = layedit.build('company_detail',{
            height : 300,
            uploadImage : {
                url : "/customer/upload_edit_img/verify"
            }
        });

        //表单提交事件
        form.on('submit(editSubmit)', function(data){
            layer.closeAll();
            $.post(formUrl,data.field,function (res) {
                if(res.rs){
                    parent.location.href = "/customer/customer_manage_view/verify"
                }
                layer.msg(res.info, {time: 2000});
            });
            return false;
        });

        form.verify({
            sync: function(){
                //用于同步编辑器内容到textarea
                layedit.sync(editIndex);
            }
        });
    })
</script>
</body>
</html>