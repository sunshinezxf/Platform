<%--
  Created by IntelliJ IDEA.
  User: sunshine
  Date: 15/7/22
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
          href="${path.concat('/material/css/dashboard.css')}"/>
    <link rel="stylesheet" type="text/css"
          href="${path.concat('/material/plugins/Font-Awesome-master/css/font-awesome.css')}"/>
    <link rel="stylesheet" type="text/css"
          href="${path.concat('/material/plugins/summernote-master/dist/summernote.css')}"/>
    <link rel="stylesheet" type="text/css" href="${path.concat('/material/css/customize.css')}"/>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/jquery/jquery-1.11.3.min.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/jquery/jquery-migrate-1.2.1.min.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/bootstrap-3.3.5-dist/js/bootstrap.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/summernote-master/dist/summernote.js')}"></script>
    <script type="text/javascript"
            src="${path.concat('/material/plugins/summernote-master/lang/summernote-zh-CN.js')}"></script>
    <title>创建文章</title>
    <script>
        $(document).ready(function () {
            $("#input-article-guidance").summernote({
                lang: "zh-CN",
                height: 290
            });
            $("#input-article-content").summernote({
                lang: "zh-CN",
                height: 430
            });
            $("#next-step").click(function () {
                $("#first-step").hide();
                $("#second-step").fadeIn("slow");
            });
            $("#previous-step").click(function () {
                $("#second-step").hide();
                $("#first-step").fadeIn("slow");
            });
            $("#guidance-radio-hand").click(function () {
                $("#guidance-edit").fadeIn("slow");
            });
            $("#guidance-radio-auto").click(function () {
                $("#guidance-edit").hide();
            });
            $("#submit").click(function () {
                var title = $("#input-article-title").val();
                var author = $("#input-article-author").val();
                var guidance = $("#input-article-guidance").code();
                var content = $("#input-article-content").code();
                var url = "${path.concat('/article/create')}";
                $("input:radio").each(function () {
                    if ($(this).attr("checked") == "checked" && $(this).attr("arial-label") == "auto") {
                        var begin = 0;
                        var end = getEndOfGuidance(content);
                        guidance = content.substring(begin, end);
                        return false;
                    }
                });
                console.debug("title: " + title);
                console.debug("author: " + author);
                console.debug("guidance: " + guidance);
                console.debug("content: " + content);
                $.post(url, {
                    title: title,
                    author: author,
                    guidance: guidance,
                    content: content
                }, function (result) {
                    location.replace('${path}' + result.url);
                });
            });
        })
        function getEndOfGuidance(content) {
            var end;
            if ((end = content.indexOf("</p>")) > 0) {
                return content.indexOf("</p>", end + 4);
            } else if ((end = content.indexOf("。")) > 0) {
                return content.indexOf("。");
            } else if ((end = content.indexOf(".")) > 0) {
                return end;
            } else {
                return content.substring(0, 20) + "..."
            }
        }
    </script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">平台——文章</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">退出</a></li>
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
            <div class="logo">
                <img src="${path.concat('/material/image/logo.png')}"/>
            </div>
            <ul class="nav nav-sidebar">
                <li><a href="#">个人中心</a></li>
                <li><a href="#">图文管理</a></li>
                <li class="active"><a href="#">发表图文<span class="sr-only">(current)</span></a></li>
                <li><a href="#">图文管理</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">素材管理</h1>
            <section class="content">
                <div id="first-step" style="display: block;">
                    <div class="form-group">
                        <label for="input-article-title">文章标题</label>
                        <input type="text" class="form-control" id="input-article-title" placeholder="文章标题">
                    </div>
                    <div class="form-group">
                        <label for="input-article-author">文章作者</label>
                        <input type="text" class="form-control" id="input-article-author" placeholder="文章作者">
                    </div>
                    <div class="form-group">
                        <label>文章导读</label>
                        <br>

                        <div class="btn-group btn-group-sm">
                            <label class="radio-inline">
                                <input id="guidance-radio-auto" name="guidance-radio" type="radio" arial-label="auto"
                                       checked="checked"><label for="guidance-radio-auto">导读自动生成</label>
                            </label>
                            <label class="radio-inline">
                                <input id="guidance-radio-hand" name="guidance-radio" type="radio"
                                       arial-label="hand"><label
                                    for="guidance-radio-hand">导读手动添加</label>
                            </label>
                        </div>
                        <br>

                        <div id="guidance-edit" style="display: none;">
                            <div id="input-article-guidance" class="form-control"></div>
                        </div>
                    </div>
                    <button class="btn btn-info" id="next-step">下一步 &gt;&gt;</button>
                </div>
                <div id="second-step" style="display: none;">
                    <div class="form-group">
                        <label>文章内容</label>

                        <div id="input-article-content" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-info" id="previous-step">&lt;&lt; 上一步</button>
                        <button class="btn btn-success" id="submit">保存图文</button>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
</body>
<script type="text/css" src="${path.concat('/material/js/article.js')}"></script>
</html>
