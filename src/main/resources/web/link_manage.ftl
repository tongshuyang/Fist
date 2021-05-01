<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/admin_head.ftl">
    <title>友链管理 -${conf.siteName!}</title>
</head>
<body class="childrenBody">

<blockquote class="layui-elem-quote">
    <form class="layui-form">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="text" class="layui-input searchName" placeholder="输入网站名" />
            </div>
        </div>
        <div class="layui-input-inline">
            <a class="layui-btn search_btn" data-type="reload">搜索</a>
            <a class="layui-btn layui-btn-warm add_btn">添加友链</a>
        </div>
    </form>
</blockquote>
<table id="linkList" lay-filter="linkList" class="layui-hide"></table>

<!--操作-->
<script type="text/html" id="linkListBar">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="alt">修改</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>

<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/rms/js/link_manage.js"></script>
</body>
</html>