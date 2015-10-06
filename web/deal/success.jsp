<%--
  Created by IntelliJ IDEA.
  User: sunshine
  Date: 15/10/6
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html lang="zh_CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="${path.concat('/material/plugins/bootstrap-3.3.5-dist/css/bootstrap.min.css')}"/>
    <link rel="stylesheet" type="text/css"
          href="${path.concat('/material/plugins/Font-Awesome-master/css/font-awesome.min.css')}"/>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/jquery/jquery-1.11.3.min.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/bootstrap-3.3.5-dist/js/bootstrap.js')}"></script>
    <title>${message.title}</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="alert alert-success"><i class="glyphicon glyphicon-ok"></i>${message.body}</div>
        <div class="btn-group" style="width: 100%">
            <a class="alert alert-info" style="width: 100%;" href="${message.link}">全文阅读</a>
        </div>
    </div>
</div>
</body>
</html>
