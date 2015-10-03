<%@ page import="platform.sunshine.model.ArticlePaymentStatus" %>
<%--
  Created by IntelliJ IDEA.
  User: sunshine
  Date: 15/9/13
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
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
    <script type="text/javascript" src="${path.concat('/material/plugins/pingpp-html5-one/pingpp_one.js')}"></script>
    <script type="text/javascript" src="${path.concat('/material/plugins/wechat/jwexin-1.0.0.js')}"></script>
    <title>平台——文章</title>
</head>
<script type="text/javascript">

    wx.config({
        debug: true,
        appId: 'wx7ba6d2f313ff5d53',
        timestamp: '${configuration.timestamp}',
        nonceStr: '${configuration.nonceStr}',
        signature: '${configuration.signature}',
        jsApiList: [
            'onMenuShareTimeline',
            'onMenuShareAppMessage'
        ]
    });

    // 2. 分享接口
    // 2.1 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口
    wx.ready(function () {

        wx.onMenuShareAppMessage({
            title: '${vo.article.title}', // 分享标题
            desc: '${vo.article.author}', // 分享描述
            link: '${configuration.shareLink}', // 分享链接
            imgUrl: '', // 分享图标
            type: '', // 分享类型,music、video或link，不填默认为link
            dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
            success: function () {

            },
            cancel: function () {

            }
        });

        // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
        wx.onMenuShareTimeline({
            title: '${vo.article.title}',
            link: '${configuration.shareLink}',
            imgUrl: '',
            trigger: function (res) {
//                // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
//                alert('用户点击分享到朋友圈');
            },
            success: function (res) {

            },
            cancel: function (res) {

            },
            fail: function (res) {

            }
        });
    });
</script>
<script type="text/javascript">
    (function () {
        WgateJs = {};
        WgateJs.auto_auth = true;
        WgateJs.gate_options = {force: 1};
        var u = (("https:" == document.location.protocol) ? "https" : "http") + "://st.weixingate.com/";
        u = u + 'st/1531';
        var d = document, g = d.createElement('script'), s = d.getElementsByTagName('script')[0];
        g.type = 'text/javascript';
        g.defer = true;
        g.async = true;
        g.src = u;
        s.parentNode.insertBefore(g, s);
    })();
</script>
<script>
    $(document).ready(function () {
        var flag = true;
        $("#article-guidance").click(function () {
            if (flag == true) {
                $("#article-guidance-content").show();
                flag = false;
            } else {
                $("#article-guidance-content").hide();
                flag = true;
            }
        });
        <%--$("#reward").click(function () {--%>
        <%--var articleId = "${vo.article.articleId}";--%>
        <%--var url = "${path.concat('/distribute/reward')}";--%>
        <%--var wgateid = WgateJs.getWgateid();--%>
        <%--$.post(url, {articleId: articleId, wgateid: wgateid}, function (result) {--%>
        <%--if (result == "success") {--%>
        <%--location.reload();--%>
        <%--}--%>
        <%--});--%>
        <%--});--%>
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
                    <span class="label label-info" id="article-guidance">文章导读
                    </span>

                    <div id="article-guidance-content"
                            <c:if test="${vo.paymentStatus eq paymentstatus}">
                                style="display:none;"
                            </c:if>>
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
<script type="text/javascript" src="${path.concat('/material/plugins/pingpp-html5-one/pingpp_one.js')}"></script>
<script>
    var articleId = "${vo.article.articleId}";
    var url = "${path.concat('/distribute/reward')}";
    var wgateid = WgateJs.getWgateid();
    $("#reward").addEventListener('click', function () {
        var order_no = wgateid + new Date().toTimeString;
        alert("orderNo: " + order_no);
        pingpp_one.init({
            app_id: 'app_0erj5GTC0yjHKCGK',
            order_no: order_no,
            amount: 10,
            channel: ['alipay_wap', 'wx_pub', 'upacp_wap', 'yeepay_wap', 'jdpay_wap', 'bfb_wap'],
            charge_url: "http://www.njuat.com/distribute/reward",
            charge_param: {articleId: articleId, wgateid: wgateid}
        }, function (res) {
            if (!res.status) {
                alert(res.msg);
            } else {
                pingpp_one.success(function (res) {
                    if (!res.status) {
                        alert(res.msg);
                    }
                }, function () {
                    window.location.reload();
                });
            }
        });
    });
</script>
</html>
