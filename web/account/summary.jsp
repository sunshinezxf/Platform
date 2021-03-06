<%--
  Created by IntelliJ IDEA.
  User: sunshine
  Date: 15/9/13
  Time: 13:40
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
    <link rel="stylesheet" type="text/css"
          href="${path.concat('/material/plugins/Font-Awesome-master/css/font-awesome.css')}"/>
    <link rel="stylesheet" type="text/css"
          href="${path.concat('/material/css/dashboard.css')}"/>
    <link rel="stylesheet" type="text/css" href="${path.concat('/material/css/customize.css')}"/>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/jquery/jquery-1.11.3.min.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/jquery/jquery-migrate-1.2.1.min.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/bootstrap-3.3.5-dist/js/bootstrap.js')}"></script>
    <script type="text/javascript" src="${path.concat('/material/js/dashboard.js')}"></script>
    <title>信息概述</title>
    <script>
        $("#article-management").collapse('hide');
        $("#account-management").collapse('show');
    </script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="">平台——文章</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${path.concat('/logout')}">退出</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="搜索文章...">
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar" id="accordion" aria-multiselectable="true">
                <li><a href="${path.concat('/dashboard')}"><i class="fa fa-desktop"></i> 首页</a></li>
                <li><a data-toggle="collapse" data-parent="#accordion" href="#article-management"><i
                        class="fa fa-book"></i> 图文管理<i
                        class="pull-right fa fa-caret-down"></i></a>
                    <ul id="article-management" class="nav nav-collapse collapse">
                        <li><a class="sub-nav" href="${path.concat('/article/create')}"><i class="fa fa-edit"></i>
                            创建图文</a>
                        </li>
                        <li><a class="sub-nav" href="${path.concat('/article/manage')}"><i class="fa fa-tasks"></i> 图文统计</a>
                        </li>
                    </ul>
                </li>
                <li class="active"><a data-toggle="collapse" data-parent="#accordion" href="#account-management"><i
                        class="fa fa-user"></i> 个人信息<i
                        class="pull-right fa fa-caret-down"></i></a>
                    <ul id="account-management" class="nav nav-collapse collapse in">
                        <li><a class="sub-nav" href="${path.concat('/account/summary')}"><i
                                class="fa fa-credit-card"></i> 信息概述<span
                                class="sr-only">(current)</span></a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
