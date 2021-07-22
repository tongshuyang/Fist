<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head.ftl">
    <title>客户信息管理 -${conf.siteName!}</title>
</head>
<body class="childrenBody">

<blockquote class="layui-elem-quote">
    <form class="layui-form">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="text" class="layui-input searchByCompanyName" placeholder="公司名称" />
            </div>
            <div class="layui-input-inline">
                <input type="text" class="layui-input searchBySaleName" placeholder="所属销售" />
            </div>
            <div class="layui-input-inline">
                <label>
                    <select id="searchByArea">
                        <option value="" selected>所属区域</option>
                        <option value="0">未分类</option>
                        <option value="1">华东</option>
                        <option value="2">华南</option>
                        <option value="3">华北</option>
                    </select>
                </label>
            </div>
            <div class="layui-input-inline">
                <label>
                    <select id="searchByLevel">
                        <option value="" selected>客户等级</option>
                        <option value="0">小体量</option>
                        <option value="1">中等</option>
                        <option value="2">重要</option>
                        <option value="3">非常重要</option>
                    </select>
                </label>
            </div>
        </div>
        <div class="layui-input-inline">
            <a class="layui-btn search_btn" data-type="reload">搜索</a>
            <a class="layui-btn layui-btn-warm add_btn">新增客户</a>
        </div>
    </form>
</blockquote>
<table id="customerList" lay-filter="customerList" class="layui-hide"></table>

<!--操作-->
<script type="text/html" id="customerListBar">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="alt">修改</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="searchCase">查看案例</a>
</script>

<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/js/customer_manage.js"></script>
</body>
</html>