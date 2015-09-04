package platform.sunshine.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.sunshine.form.ArticleForm;
import platform.sunshine.model.Article;
import platform.sunshine.model.ArticlePaymentStatus;
import platform.sunshine.utils.Encryption;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.vo.ArticleViewVO;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunshine on 15/7/23.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    private static ArticleViewVO vo = new ArticleViewVO();

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public ModelAndView create() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/article/create");
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public Map<String, Object> create(@Valid ArticleForm articleForm, BindingResult result) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        if (result.hasErrors()) {
            params.put("status", ResponseCode.RESPONSE_ERROR);
            return params;
        }
        Article article = new Article(articleForm);
        String preparedArticleId = Encryption.md5(article.getTitle() + article.getCreateAt());
        article.setArticleId(preparedArticleId);
        vo.setArticle(article);
        vo.setPaymentStatus(ArticlePaymentStatus.ARTICLE_NOT_PAYED);
        params.put("status", ResponseCode.RESPONSE_OK);
        params.put("url", "/article/" + preparedArticleId);
        return params;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{articleId}")
    public ModelAndView view(@PathVariable String articleId) {
        ModelAndView view = new ModelAndView();
        view.setViewName("/article/view");
        view.addObject("vo", vo);
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reward")
    @ResponseBody
    public void reward(HttpServletResponse response) throws IOException {
        vo.setPaymentStatus(ArticlePaymentStatus.ARTICLE_PAYED);
        response.getWriter().print("success");
    }
}
