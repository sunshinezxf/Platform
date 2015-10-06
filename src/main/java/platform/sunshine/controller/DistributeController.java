package platform.sunshine.controller;

import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Event;
import com.pingplusplus.model.Webhooks;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.sunshine.form.ChargeForm;
import platform.sunshine.model.*;
import platform.sunshine.service.ArticleService;
import platform.sunshine.service.DealService;
import platform.sunshine.service.ReaderService;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;
import platform.sunshine.utils.Tools;
import platform.sunshine.utils.WechatConfig;
import platform.sunshine.vo.ArticleViewVO;
import platform.sunshine.vo.MessageVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by sunshine on 15/8/28.
 */
@RestController
@RequestMapping("/distribute")
public class DistributeController {
    private Logger logger = LoggerFactory.getLogger(DistributeController.class);

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private DealService dealService;

    @RequestMapping(method = RequestMethod.GET, value = "/{articleId}")
    public ModelAndView distribute(@PathVariable String articleId, HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        String wxopenid = request.getParameter("wxopenid");
        String wechat = request.getParameter("wgateid");
        String verify = request.getParameter("verify");
        String articleURL = "";
        if (!StringUtils.isEmpty(wechat)) {
            Reader reader = new Reader();
            reader.setReaderWechat(wechat);
            ResultData readerExistMessage = readerService.queryReader(reader);
            if (readerExistMessage.getResponseCode() == ResponseCode.RESPONSE_NULL) {
                readerService.createReader(reader);
            } else if (readerExistMessage.getResponseCode() == ResponseCode.RESPONSE_ERROR) {

            }
        }
        //根据文章的ID查询图文信息
        ArticleViewVO vo = new ArticleViewVO();
        Article article = new Article();
        article.setArticleId(articleId);
        ResultData articleMessage = articleService.queryArticle(article);
        vo.setArticle((Article) articleMessage.getData());
        //根据文章的ID和用户的微信标识查询当前用户是否已经打赏过此文章
        if (!StringUtils.isEmpty(wechat)) {
            Deal deal = new Deal(wechat, articleId);
            ResultData dealMessage = dealService.queryDealRecord(deal);
            if (dealMessage.getResponseCode() == ResponseCode.RESPONSE_OK) {
                vo.setPaymentStatus(ArticlePaymentStatus.ARTICLE_PAYED);
            } else {
                vo.setPaymentStatus(ArticlePaymentStatus.ARTICLE_NOT_PAYED);
            }
        } else {
            vo.setPaymentStatus(ArticlePaymentStatus.ARTICLE_NOT_PAYED);
        }
        view.setViewName("/distribute/view");
        view.addObject("vo", vo);
        if (!StringUtils.isEmpty(wechat)) {
            String url = "http://www.njuat.com/distribute/" + articleId + "?wxopenid=" + wxopenid + "&wgateid=" + wechat + "&verify=" + verify;
            Configuration configuration = WechatConfig.config(url);
            try {
                String shareURL = "http://www.weixingate.com/gate.php?back=" + URLEncoder.encode("http://www.njuat.com/distribute/" + articleId, "utf-8") + "&force=1";
                configuration.setShareLink(shareURL);
            } catch (Exception e) {

            }
            view.addObject("configuration", configuration);
            view.addObject("wgateid", wechat);
        }
        return view;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{articleId}/deal/success")
    public ModelAndView success(@PathVariable String articleId) {
        ModelAndView view = new ModelAndView();
        MessageVO message = new MessageVO();
        try {
            message.setTitle("付款成功");
            message.setBody("你刚刚的操作已成功");
            String shareURL = "http://www.weixingate.com/gate.php?back=" + URLEncoder.encode("http://www.njuat.com/distribute/" + articleId, "utf-8") + "&force=1";
            message.setLink(shareURL);
        } catch (Exception e) {

        }
        view.addObject("message", message);
        view.setViewName("/deal/success");
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reward")
    @ResponseBody
    public String reward(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject webhooks = Tools.getParams(request);
        logger.debug("webhooks info == " + webhooks);
        JSONObject charge = webhooks.getJSONObject("data").getJSONObject("object");
        logger.debug("charge info == " + charge);
        String dealId = charge.getString("order_no");
        logger.debug("deal id: " + dealId);
        if (charge.getBoolean("paid") == true) {
            Deal deal = new Deal();
            deal.setDealId(dealId);
            deal.setDealStatus(true);
            dealService.updateDealRecord(deal);
        }
        Event event = Webhooks.eventParse(webhooks.toString());
        if ("charge.succeeded".equals(event.getType())) {
            response.setStatus(200);
        } else if ("refund.succeeded".equals(event.getType())) {
            response.setStatus(200);
        } else {
            response.setStatus(500);
        }
        return "complete";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/charge")
    @ResponseBody
    public Charge charge(HttpServletRequest request) {
        //获取请求body中的参数
        JSONObject params = Tools.getParams(request);
        //文章的标识
        String articleId = params.getString("articleId");
        //付款读者的标识
        String wechat = params.getString("wgateid");
        //付款的渠道
        String channel = params.getString("channel");
        //当前页面的URL
        String url = params.getString("url");
        //付款的金额
        int amount = params.getInt("amount");
        //获取请求的IP地址
        String ip = Tools.getIP(request);

        Deal deal = new Deal(wechat, articleId);
        deal.setDealPayment(amount);
        deal.setClientIp(ip);
        if (dealService.queryDealRecord(deal).getResponseCode() == ResponseCode.RESPONSE_NULL) {
            ResultData createMessage = dealService.createDealRecord(deal);
            if (createMessage.getResponseCode() == ResponseCode.RESPONSE_OK) {
                logger.debug("Insert a deal record successfully.");
            } else {
                logger.debug("Fail to insert a deal record.");
                return null;
            }
        }

        //设置订单的ID
        String orderNo = deal.getDealId();

        //根据文章的标识查询文章的信息
        Article article = new Article();
        article.setArticleId(articleId);
        article = (Article) articleService.queryArticle(article).getData();

        Reader reader = new Reader();
        if (!StringUtils.isEmpty(wechat)) {
            reader.setReaderWechat(wechat);
            ResultData readerExistMessage = readerService.queryReader(reader);
            if (readerExistMessage.getResponseCode() == ResponseCode.RESPONSE_NULL) {
                readerService.createReader(reader);
            } else if (readerExistMessage.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
                return null;
            }
        }

        ChargeForm form = new ChargeForm(orderNo, article, reader, channel, amount, ip, url);
        ResultData result = dealService.charge(form);

        Charge charge = (Charge) result.getData();
        logger.debug(charge.toString());
        return charge;
    }
}
