package platform.sunshine.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.sunshine.ArticleViewVO;
import platform.sunshine.form.ArticleForm;
import platform.sunshine.model.Article;
import platform.sunshine.model.ArticlePaymentStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by sunshine on 15/7/23.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public ModelAndView create() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/article/create");
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseBody
    public String create(@Valid ArticleForm articleForm, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "failure";
        }
        System.out.println("title: " + articleForm.getTitle());
        System.out.println("author: " + articleForm.getAuthor());
        System.out.println("guidance: " + articleForm.getGuidance());
        System.out.println("content: " + articleForm.getContent());
        ArticleViewVO vo = new ArticleViewVO();
        vo.setPaymentStatus(ArticlePaymentStatus.ARTICLE_NOT_PAYED);
        Article article = new Article(articleForm);
        vo.setArticle(article);
        return "success";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{articleId}")
    public ModelAndView view(@PathVariable String articleId) {
        ModelAndView view = new ModelAndView();
        view.setViewName("/article/view");
        view.addObject("status", ArticlePaymentStatus.ARTICLE_PAYED);
        return view;
    }
}
