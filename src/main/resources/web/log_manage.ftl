<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/admin_head.ftl">
    <title>登录日志管理 -${conf.siteName!}</title>
</head>
<body class="childrenBody">

<blockquote class="layui-elem-quote">
    <form class="layui-form">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="text" class="layui-input searchAccount" placeholder="账户" />
            </div>
            <div class="layui-input-inline">
                <label>
                    <select id="type">
                        <option value="" selected>用户类型</option>
                        <option value="0">用户</option>
                        <option value="1">管理员</option>
                    </select>
                </label>
            </div>
            <div class="layui-input-inline">
                <label>
                    <select id="result">
                        <option value="" selected>登录结果</option>
                        <option value="0">登录成功</option>
                        <option value="1">用户不存在</option>
                        <option value="2">密码错误</option>
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
<table id="logList" lay-filter="logList" class="layui-hide"></table>

<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/rms/js/log_manage.js"></script>
</body>
</html>