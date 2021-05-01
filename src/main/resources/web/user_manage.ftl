<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head.ftl">
    <title>后台用户管理 -${conf.siteName!}</title>
</head>
<body class="childrenBody">

<blockquote class="layui-elem-quote">
    <form class="layui-form">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="text" class="layui-input searchUsername" placeholder="输入用户名" />
            </div>
        </div>
        <div class="layui-input-inline">
            <a class="layui-btn search_btn" data-type="reload">搜索</a>
            <a class="layui-btn layui-btn-warm add_btn">添加用户</a>
        </div>
    </form>
</blockquote>
<table id="adminUserList" lay-filter="adminUserList" class="layui-hide"></table>

<!--操作-->
<script type="text/html" id="adminUserListBar">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="alt">修改</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="ban">禁用</a>
</script>

<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/rms/js/admin_user_manage.js"></script>
</body>
</html>