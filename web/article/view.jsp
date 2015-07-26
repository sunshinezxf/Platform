<%@ page import="platform.sunshine.model.ArticlePaymentStatus" %>
<%--
  Created by IntelliJ IDEA.
  User: sunshine
  Date: 15/7/25
  Time: 11:02
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
<body>
<div class="container">
    <section id="article">
        <c:set var="paymentstatus" value="<%=ArticlePaymentStatus.ARTICLE_PAYED %>"></c:set>
        <div class="blog-post">
            <h3 class="blog-post-title">爱情日记：越简单就越幸福</h3>

            <div class="blog-post-meta"><a>章许帆</a> 2015年7月25日</div>
            <div class="blog-post-preview">
                <div class="alert alert-info blog-post-guidance">
                    <span class="label label-info" id="article-guidance">文章导读</span>

                    <div id="article-guidance-content">
                        <hr/>
                        <p>潮起潮落，云卷云舒。人生最难读懂的，便是心情。</p>

                        <p>
                            漫步在林荫道上，想要简单一点的景致，却总是迎来一阵狂风，扰乱了安静的步调，走在沙滩上遐想，想要静听海浪拍打沙滩的声音，却总是传来轰鸣的汽笛声，忽灭了美丽的幻想，想要一个人，一杯红酒，在一方小田地里，呆上一整天，却总是放不下调了静音的手机，并难以真正拉上窗帘不让一丝阳光进来。</p>

                        <p>能感受到的失落不叫失落，能读懂的寂寞不叫寂寞。</p>

                        <p>
                            多少人不知道在林荫道上遇到了狂风，欲思着你思念着的人，正风驰电车向你疾驰而来，沙滩上轰鸣的汽笛声，或许代表另一个希望已经从平安到达这一头，正在船头正在向你招手，而你在一方小田地里放心不下的才是真正的生活。</p>

                        <p>
                            从来没有停下的脚步，酸甜苦辣的生活冲刺着许多无奈，心情就像充满岔路口的行程，时而会让你迷失方向，在忙碌，也不要忘了爱惜自己。在闲暇，也不要忘了奋斗的梦想，在低谷，也不要忘了许多牵挂你的人，在繁华，也不能忘了最初的心。这样就不会在心情的岔路口找不到最初的自己。</p>

                        <p>
                            想要的东西，努力去争取。要之不得的，要学会放弃，幸福从来不会主动像你奔来，也不会在寻找的路途中偶遇。痛苦也不会强行占满你的心，或者在灵敏的全世界，他们就像命运一样，静静等在某个路口，选择简单的路。得到了幸福。选择欲望的人，得到了痛苦。盼宿命的人，他在最初就已经选择了结局。谈悲伤的人，往往在人生的折子戏中就已经入戏太深。要相信命运，因为它可以争取，不要相信命运，因为它改变不了坚定的你。</p>

                        <p>朝看东流水，暮看玉溪坠。世间最无情的，便是时间。</p>

                        <p>
                            人生太短，区区三万个朝夕，以其有空去患得患失，唉声叹气。还不如拾起一片落了的叶，捡起一朵谢了的花，倾听他们诉说关于逝去的意义。人生无常，归宿确实一样的。归宿是一样的，意义却大不相同。雨滴再小也是会成海洋的一份子。落叶再不起眼也滋养了大地。醒一醒吧。坐看潮起潮落，笑谈云卷云舒。平凡一点。最容易读懂的心情。便是波澜不惊。</p>
                    </div>
                </div>
                <c:if test="${status ne paymentstatus}">
                    <div class="btn-group" style="width: 100%;">
                        <button class="alert alert-success" style="width: 100%;">打赏继续阅读 &gt;&gt;</button>
                    </div>
                </c:if>
            </div>
            <c:if test="${status eq paymentstatus}">
                <div class="blog-post-detail">
                    <div class="alert alert-info blog-post-content">
                        <span class="label label-info" id="article-content">文章正文</span>
                    </div>
                </div>
            </c:if>
        </div>
    </section>
</div>
</body>
</html>
