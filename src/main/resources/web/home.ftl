<!DOCTYPE html>
<html lang="en">
<head>
    <#include "head.ftl">
    <title>首页-${conf.siteName!}</title>
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote layui-bg-green">
    <div id="nowTime"></div>
</blockquote>
<div class="layui-row layui-col-space10 panel_box">
    <div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
        <a href="javascript:" data-url="/leave_word/rms/leave_word_manage">
            <div class="panel_icon layui-bg-green">
                <i class="layui-icon seraph layui-anim layui-icon-form"></i>
            </div>
            <div class="panel_word">
                <span>${home.leaveWord}</span>
                <em>新的留言</em>
                <cite class="layui-hide">网站留言</cite>
            </div>
        </a>
    </div>
    <div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
        <a href="javascript:" data-url="/comment/rms/comment_manage">
            <div class="panel_icon layui-bg-cyan">
                <i class="layui-anim layui-icon layui-icon-dialogue"></i>
            </div>
            <div class="panel_word">
                <span>${home.comment}</span>
                <em>待审核评论</em>
                <cite class="layui-hide">用户评论</cite>
            </div>
        </a>
    </div>
    <div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
        <a href="javascript:" data-url="/visits/rms/visits_manage">
            <div class="panel_icon layui-bg-red">
                <i class="layui-icon layui-anim seraph layui-icon-log"></i>
            </div>
            <div class="panel_word">
                <span>${visits.daily}</span>
                <em>日访问量</em>
                <cite class="layui-hide">访问量统计</cite>
            </div>
        </a>
    </div>
    <div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
        <a href="javascript:" data-url="/visits/rms/visits_manage">
            <div class="panel_icon layui-bg-black">
                <i class="layui-anim seraph icon-clock"></i>
            </div>
            <div class="panel_word">
                <#assign count = visits.daily + visits.count>
                <span>${count}</span>
                <em>总访问量</em>
                <cite class="layui-hide">访问量统计</cite>
            </div>
        </a>
    </div>
    <div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
        <a href="javascript:" data-url="/user/rms/user_manage">
            <div class="panel_icon layui-bg-orange">
                <i class="layui-anim seraph icon-icon10" data-icon="icon-icon10"></i>
            </div>
            <div class="panel_word userAll">
                <span>${home.userCount}</span>
                <em>用户总数</em>
                <cite class="layui-hide">用户列表</cite>
            </div>
        </a>
    </div>
    <div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
        <a href="javascript:" data-url="/log/rms/log_manage">
            <div class="panel_icon layui-bg-blue">
                <i class="layui-anim seraph icon-log"></i>
            </div>
            <div class="panel_word">
                <span style="font-size: 14px;color: rgba(95, 184, 120, 1)">${home.lastLogin.time!?datetime} <br> ${home.lastLogin.address!}</span>
                <em>上次登录信息</em>
                <cite class="layui-hide">登录日志</cite>
            </div>
        </a>
    </div>
</div>
<div class="layui-row layui-col-space10">
    <div class="layui-col-lg6 layui-col-md12">
        <blockquote class="layui-elem-quote title">系统基本参数</blockquote>
        <table class="layui-table magt0">
            <colgroup>
                <col width="150">
                <col>
            </colgroup>
            <tbody>
            <tr>
                <td>网站名称</td>
                <td>${conf.siteName!}</td>
            </tr>
            <tr>
                <td>开发作者</td>
                <td>${conf.author!}</td>
            </tr>
            <tr>
                <td>备案号</td>
                <td>${conf.record!}</td>
            </tr>
            <tr>
                <td>最大上传限制</td>
                <td>${conf.maxUpload!} KB</td>
            </tr>
            <tr>
                <td>数据库版本</td>
                <td>MYSQL 8.0</td>
            </tr>
            <tr>
                <td>服务器环境</td>
                <td>Linux CentOS 7.2</td>
            </tr>
            <tr>
                <td>当前用户权限</td>
                <td><#if adminUser.role = 1>普通后台管理<#else>上天入地超级管理</#if></td>
            </tr>
            </tbody>
        </table>
        <br>
        <h2>日积月累，日新月异。</h2>
    </div>
    <div class="layui-col-lg6 layui-col-md12">
        <blockquote class="layui-elem-quote title">最近留言 <i class="layui-icon layui-red">&#xe756;</i></blockquote>
        <table class="layui-table mag0" lay-skin="line">
            <colgroup>
                <col width="100">
                <col>
            </colgroup>
            <tbody>
            <#list home.leaveWordList as leaveWord>
                <tr>
                    <td>${leaveWord.name!} : </td>
                    <td>${leaveWord.content!} —${leaveWord.createTime!?string("yyyy/MM/dd HH:mm")}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/rms/js/home.js"></script>
</body>
</html>