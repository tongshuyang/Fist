<!DOCTYPE html>
<html lang="en" class="loginHtml">
<head>
    <#include "head.ftl">
    <title>登入-${conf.siteName!}</title>
</head>
<body class="loginBody">
<form class="layui-form">
    <div class="title">${conf.siteName!}</div>
    <div class="layui-form-item input-item">
        <label for="userName">用户名</label>
        <input type="text" placeholder="请输入用户名" autocomplete="off" name="username" class="layui-input" lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label for="password">密码</label>
        <input type="password" placeholder="请输入密码" autocomplete="off" name="password" class="layui-input" lay-verify="required">
    </div>
    <div class="layui-form-item input-item" id="imgCode">
        <label for="code">验证码</label>
        <input type="text" placeholder="请输入验证码" autocomplete="off" name="code" class="layui-input" lay-verify="required">
        <img src="/user/get_verify_code" id="imgObj" onclick="changeImg()" alt="verify">
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-block" lay-filter="sign_in" lay-submit>登录</button>
    </div>
</form>
<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/js/sign_in.js"></script>
<script type="text/javascript" src="/static/mine/js/cache.js"></script>
<script>
    //在最外层页面打开
    if (window !== top){
        top.location.href = location.href;
    }
    // 刷新验证码图片
    function changeImg() {
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", src + "?r=" + Math.floor(Math.random()*100));
    }
</script>
</body>
</html>