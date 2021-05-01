<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/admin_head.ftl">
    <title>动态管理 -${conf.siteName!}</title>
</head>
<body class="childrenBody">

<blockquote class="layui-elem-quote">
    <form class="layui-form">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="text" class="layui-input searchTitle" placeholder="输入标题" />
            </div>
            <div class="layui-input-inline">
                <label>
                    <select id="type">
                        <option value="" selected>全部类型</option>
                        <option value="0">优惠活动</option>
                        <option value="1">爱车知识</option>
                        <option value="2">通知公告</option>
                        <option value="3">本店招聘</option>
                    </select>
                </label>
            </div>
            <div class="layui-input-inline">
                <label>
                    <select id="state">
                        <option value="" selected>全部</option>
                        <option value="0">显示</option>
                        <option value="1">不显示</option>
                        <option value="2">已删除</option>
                    </select>
                </label>
            </div>
        </div>
        <div class="layui-input-inline">
            <a class="layui-btn search_btn" data-type="reload">搜索</a>
            <a class="layui-btn layui-btn-warm add_btn">发布动态</a>
        </div>
    </form>
</blockquote>
<table id="movingList" lay-filter="movingList" class="layui-hide"></table>

<!--操作-->
<script type="text/html" id="movingListBar">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="alt">修改</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>

<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/rms/js/moving_manage.js"></script>
</body>
</html>