layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = layui.layer;
        $ = layui.jquery;

    //登录按钮
    form.on('submit(sign_in)',function(data){
        layer.load(2);
        $.post("/user/sign_in",data.field,function(res){
            layer.closeAll('loading');
            if(res.rs){
                window.location.href = "/fist";
            }else{
                layer.msg(res.info, {time: 2000});
            }
        },'json');
        return false;
    });

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    });
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    });
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() !== ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
});
