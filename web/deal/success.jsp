<%--
  Created by IntelliJ IDEA.
  User: sunshine
  Date: 15/8/13
  Time: 20:08
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
    <script type="text/javascript"
            src="${path.concat('/material/plugins/jquery/jquery-1.11.3.min.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/jquery/jquery-migrate-1.2.1.min.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/bootstrap-3.3.5-dist/js/bootstrap.js')}"></script>
    <title>${message.title}</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${path.concat('/index')}">平台——文章</a>
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
    <form class="form-signin" id="lg-form">
        <h2 class="form-signin-heading">
            操作提示
        </h2>

        <div class="alert alert-info">
            <p>温馨提示您，您刚刚操作结果：</p>

            <p><i class="glyphicon glyphicon-pencil"></i>&nbsp;&nbsp;${message.title}</p>

            <p>您可以点击下方按钮以继续操作</p>
        </div>

        <a href="${message.link}" class="btn btn-lg btn-primary btn-block btn-info">点击返回</a>
    </form>
</div>
</body>
</html>
