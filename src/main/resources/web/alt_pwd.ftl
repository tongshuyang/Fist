<!DOCTYPE html>
<html lang="en">
<head>
	<#include "head.ftl">
	<title>修改密码-${conf.siteName!}</title>
</head>
<body class="childrenBody">
<form class="layui-form layui-row changePwd">
	<div class="layui-col-xs12 layui-col-sm6 layui-col-md6">
		<div class="layui-form-item">
			<label><input name="id" type="number" value="${adminUser.id}" disabled class="layui-input layui-hide"></label>
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<label><input type="text" value="${adminUser.username}" disabled class="layui-input layui-disabled"></label>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">旧密码</label>
			<div class="layui-input-block">
				<input name="oldPwd" type="password" placeholder="请输入旧密码" lay-verify="required|pwd" class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">新密码</label>
			<div class="layui-input-block">
				<input name="newPwd" type="password" placeholder="请输入新密码" lay-verify="required|pwd" id="newPwd" class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-block">
				<input type="password" placeholder="请确认密码" lay-verify="required|confirmPwd" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="altPwd">立即修改</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="/static/layui/layui.js"></script>
<script type="text/javascript" src="/static/mine/rms/js/alt_pwd.js"></script>
</body>
</html>