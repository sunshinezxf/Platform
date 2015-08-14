<%--
  Created by IntelliJ IDEA.
  User: sunshine
  Date: 15/8/13
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon"
          href="${path.concat('/material/ico/logo.ico')}"/>
    <link rel="stylesheet"
          href="${path.concat('/material/plugins/bootstrap-3.3.5-dist/css/bootstrap.css')}"/>
    <link rel="stylesheet" href="${path.concat('/material/css/signin.css')}"/>
    <title>注册</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">平台——文章</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${path.concat('/login')}">登录</a></li>
                <li><a href="${path.concat('/register')}">注册</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <form class="form-register">
        <h2 class="form-register-heading">
            注册
        </h2>

        <div class="form-group has-feedback">
            <label for="account_email" class="sr-only">
                Email address
            </label>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            <input type="email" class="form-control" id="account_email"
                   placeholder="邮箱" required="" autocomplete="off">
        </div>
        <div class="form-group has-feedback">
            <label for="account_password" class="sr-only">
                Password
            </label>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            <input type="password" class="form-control"
                   id="account_password" placeholder="密码" required="" autocomplete="off">
        </div>
        <div class="form-group has-feedback">
            <label for="confirm_account_password" cla   ss="sr-only">
                Confirm Password
            </label>
            <span class="glyphicon glyphicon-flag form-control-feedback"></span>
            <input type="password" class="form-control"
                   id="confirm_account_password" placeholder="确认密码" required="" autocomplete="off">
        </div>
        <button type="submit" class="btn btn-lg btn-primary btn-block btn-info">
            注册
        </button>
    </form>
</div>
</body>
</html>
