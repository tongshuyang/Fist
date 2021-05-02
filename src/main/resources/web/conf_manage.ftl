<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head.ftl">
    <title>网站配置管理 -${conf.siteName!}</title>
</head>
<body class="childrenBody">

<blockquote class="layui-elem-quote">
    <form class="layui-form">
        <div class="layui-input-inline">
            <input type="text" class="layui-input searchRemark" placeholder="备注" />
        </div>
        <div class="layui-input-inline">
            <a class="layui-btn search_btn" data-type="reload">搜索</a>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </form>
</blockquote>
<table id="confList" lay-filter="confList" class="layui-hide"></table>

<!--操作-->
<script type="text/html" id="confListBar">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="alt">修改</a>
</script>

<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/js/conf_manage.js"></script>
</body>
</html>