package platform.sunshine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sunshine on 15/7/23.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping(method = RequestMethod.GET, value="/create")
    public ModelAndView create(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/article/create");
        return view;
    }
}
