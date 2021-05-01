<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/admin_head.ftl">
    <title>通知管理 -${conf.siteName!}</title>
</head>
<body class="childrenBody">

<blockquote class="layui-elem-quote">
    <form class="layui-form">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="number" class="layui-input searchUserId" placeholder="用户ID" />
            </div>
            <div class="layui-input-inline">
                <label>
                    <select id="state">
                        <option value="" selected>全部</option>
                        <option value="0">未查看</option>
                        <option value="1">已查看</option>
                        <option value="2">已删除</option>
                    </select>
                </label>
            </div>
        </div>
        <div class="layui-input-inline">
            <a class="layui-btn search_btn" data-type="reload">搜索</a>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </form>
</blockquote>
<table id="noticeList" lay-filter="noticeList" class="layui-hide"></table>

<!--操作-->
<script type="text/html" id="noticeListBar">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="alt">修改</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>

<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/rms/js/notice_manage.js"></script>
</body>
</html>