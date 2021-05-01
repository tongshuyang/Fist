layui.use(['form','layer','laydate','table','laytpl'],function() {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery;

    //表单提交
    form.on('submit(altPwd)',function(data){
        layer.load(2);
        $.post("/admin_user/rms/alt_pwd",data.field,function(res){
            layer.closeAll('loading');
            if(res.rs){
                layer.alert(res.info, {
                    skin: 'layui-layer-lan' //样式类名
                    ,closeBtn: 0
                    ,anim: 4 //动画类型
                }, function(){
                    top.location.href = "/admin_user/sign_in"
                });
            }else{
                layer.msg(res.info, {time: 2000});
            }
        },'json');
        return false;
    });

    //添加验证规则
    form.verify({
        pwd: [/^[\S]{6,12}$/,'密码必须6到12位，且不能有空格'],
        confirmPwd: function (value, item) {
            if (!new RegExp($("#newPwd").val()).test(value)) {
                return "两次输入密码不一致，请重新输入！";
            }
        }
    })
});