package platform.sunshine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.sunshine.model.Article;
import platform.sunshine.model.ArticlePaymentStatus;
import platform.sunshine.model.Deal;
import platform.sunshine.model.Reader;
import platform.sunshine.service.ArticleService;
import platform.sunshine.service.DealService;
import platform.sunshine.service.ReaderService;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;
import platform.sunshine.vo.ArticleViewVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String wechat = request.getParameter("wgateid");
        logger.debug("wechat: " + wechat);
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
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reward")
    @ResponseBody
    public void reward(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String articleId = request.getParameter("articleId");
        String wechat = request.getParameter("wgateid");
        if (StringUtils.isEmpty(wechat)) {
            response.getWriter().print("failure");
            return;
        } else {
            Reader reader = new Reader();
            reader.setReaderWechat(wechat);
            ResultData readerExistMessage = readerService.queryReader(reader);
            if (readerExistMessage.getResponseCode() == ResponseCode.RESPONSE_NULL) {
                readerService.createReader(reader);
            } else if (readerExistMessage.getResponseCode() == ResponseCode.RESPONSE_ERROR) {

            }
        }
        Deal deal = new Deal(wechat, articleId);
        ResultData result = dealService.createDealRecord(deal);
        if (result.getResponseCode() == ResponseCode.RESPONSE_OK) {
            response.getWriter().print("success");
        } else {
            response.getWriter().print("failure");
        }
    }
}
