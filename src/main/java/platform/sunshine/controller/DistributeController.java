package platform.sunshine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import platform.sunshine.service.ArticleService;

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

    @RequestMapping(method = RequestMethod.GET, value = "/{articleId}")
    public ModelAndView distribute(@PathVariable String articleId) {
        String openId;
        ModelAndView view = new ModelAndView();

        view.setViewName("/distribute/view");
        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reward")
    @ResponseBody
    public void reward(HttpServletResponse response) throws IOException {

        response.getWriter().print("success");
    }
}
