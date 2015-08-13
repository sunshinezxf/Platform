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
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
</body>
</html>
