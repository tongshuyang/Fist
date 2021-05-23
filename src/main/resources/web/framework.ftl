<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="format-detection" content="telephone=no">
    <meta name="author" content="SoyungTong">
    <meta name="renderer" content="webkit">

    <title>${conf.siteName!} Case Manage</title>

    <link rel="alternate icon" type="image/png" href="${conf.endpoint!}${conf.favicon!}">
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/static/mine/css/index.css" media="all" />
</head>
<body class="main_body">
<div class="layui-layout layui-layout-admin">
    <!-- 顶部 -->
    <div class="layui-header header">
        <div class="layui-main mag0">
            <a href="#" class="logo">${conf.siteName!}</a>
            <!-- 显示/隐藏菜单 -->
            <a href="javascript:" class="seraph hideMenu icon-caidan"></a>
            <!-- 顶部右侧菜单 -->
            <ul class="layui-nav top_menu">
                <li class="layui-nav-item" pc>
                    <a href="javascript:" class="clearCache"><i class="layui-icon" data-icon="&#xe640;">&#xe640;</i><cite>清除缓存</cite></a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:">${user.username!}</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:" data-url="/user/alt_pwd_view/verify"><i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>修改密码</cite></a></dd>
                        <dd pc><a href="javascript:" class="functionSetting"><i class="layui-icon">&#xe620;</i><cite>功能设定</cite></a></dd>
                        <dd><a id="signOut"><i class="seraph icon-tuichu"></i><cite>退出</cite></a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧导航 -->
    <div class="layui-side layui-bg-black">
        <div class="user-photo">
            <a class="img"><img src="${conf.endpoint!}${conf.favicon!}" class="userAvatar" alt="logo"></a>
            <p><span class="userName">${user.username!}</span> ，欢迎登录</p>
            <div id="role" class="layui-hide">${user.role!}</div>
        </div>

        <div class="navBar layui-side-scroll" id="navBar">
            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item layui-this">
                    <a href="javascript:" data-url="page/main.html"><i class="layui-icon" data-icon=""></i><cite>后台首页</cite></a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 右侧内容 -->
    <div class="layui-body layui-form">
        <div class="layui-tab mag0" lay-filter="bodyTab" id="top_tabs_box">
            <ul class="layui-tab-title top_tab" id="top_tabs">
                <li class="layui-this" lay-id=""><i class="layui-icon">&#xe68e;</i> <cite>后台首页</cite></li>
            </ul>
            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <a href="javascript:"><i class="layui-icon caozuo">&#xe643;</i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:" class="refresh refreshThis"><i class="layui-icon layui-icon-refresh"></i> 刷新当前</a></dd>
                        <dd><a href="javascript:" class="closePageOther"><i class="seraph icon-prohibit"></i> 关闭其他</a></dd>
                        <dd><a href="javascript:" class="closePageAll"><i class="seraph icon-guanbi"></i> 关闭全部</a></dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content clildFrame">
                <div class="layui-tab-item layui-show">
                    <iframe src="/fist/home"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部 -->
    <div class="layui-footer footer">
        <p><span>${conf.copyRight!}</span></p>
    </div>
</div>

<!-- 移动导航 -->
<div class="site-tree-mobile"><i class="layui-icon layui-icon-right"></i></div>
<div class="site-mobile-shade"></div>

<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/js/index.js"></script>
<script type="text/javascript" src="/static/mine/js/cache.js"></script>
</body>
</html>