package platform.sunshine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.sunshine.model.Article;
import platform.sunshine.model.Reader;
import platform.sunshine.service.ArticleService;
import platform.sunshine.service.ReaderService;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;
import platform.sunshine.vo.ArticleViewVO;

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

    @RequestMapping(method = RequestMethod.GET, value = "/{articleId}")
    public ModelAndView distribute(@PathVariable String articleId) {
        String openId = "";
        ModelAndView view = new ModelAndView();
        Reader reader = new Reader();
        reader.setReaderWechat(openId);
        ResultData readerExistMessage = readerService.queryReader(reader);
        if (readerExistMessage.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            readerService.createReader(reader);
        } else if (readerExistMessage.getResponseCode() == ResponseCode.RESPONSE_ERROR) {

        }
        //根据文章的ID查询图文信息
        ArticleViewVO vo = new ArticleViewVO();
        Article params = new Article();
        ResultData articleMessage = articleService.queryArticle(params);
        vo.setArticle((Article) articleMessage.getData());
        //根据文章的ID和用户的微信标识查询当前用户是否已经打赏过此文章
        
        view.setViewName("/distribute/view");
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reward")
    @ResponseBody
    public void reward(HttpServletResponse response) throws IOException {

        response.getWriter().print("success");
    }
}
