<%@ page import="platform.sunshine.model.ArticlePaymentStatus" %>
<%--
  Created by IntelliJ IDEA.
  User: sunshine
  Date: 15/7/25
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon"
          href="${path.concat('/material/ico/logo.ico')}"/>
    <link rel="stylesheet" type="text/css"
          href="${path.concat('/material/plugins/bootstrap-3.3.5-dist/css/bootstrap.css')}"/>
    <link rel="stylesheet" type="text/css"
          href="${path.concat('/material/plugins/Font-Awesome-master/css/font-awesome.css')}"/>
    <link rel="stylesheet" type="text/css"
          href="${path.concat('/material/css/blog.css')}"/>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/jquery/jquery-1.11.3.min.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/bootstrap-3.3.5-dist/js/bootstrap.js')}"></script>
    <title>平台——文章</title>
</head>
<script>
    $(document).ready(function () {
        $("#reward").click(function () {
            var url = "${path.concat('/article/reward')}";
            $.post(url, function (result) {
                if (result == "success") {
                    location.reload();
                }
            });
        });
    });
</script>
<body>
<div class="container">
    <section id="article">
        <c:set var="paymentstatus" value="<%=ArticlePaymentStatus.ARTICLE_PAYED %>"></c:set>
        <div class="blog-post">
            <h3 class="blog-post-title">${vo.article.title}</h3>

            <div class="blog-post-meta"><a>${vo.article.author}</a> <fmt:formatDate value="${vo.article.createAt}"
                                                                                    pattern="yyyy年MM月dd日"/></div>
            <div class="blog-post-preview">
                <div class="alert alert-info blog-post-guidance">
                    <span class="label label-info" id="article-guidance">文章导读</span>

                    <div id="article-guidance-content">
                        <hr/>
                        ${vo.article.guidance}
                    </div>
                </div>
                <c:if test="${vo.paymentStatus ne paymentstatus}">
                    <div class="btn-group" style="width: 100%;">
                        <button class="alert alert-success" style="width: 100%;" id="reward">打赏继续阅读 &gt;&gt;</button>
                    </div>
                </c:if>
            </div>
            <c:if test="${vo.paymentStatus eq paymentstatus}">
                <div class="blog-post-detail">
                    <div class="alert alert-info blog-post-content">
                        <span class="label label-info" id="article-content">文章正文</span>

                        <div id="article-detail-content">
                            <hr/>
                                ${vo.article.content}
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </section>
</div>
</body>
</html>
