package platform.sunshine.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sunshine on 15/8/29.
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/summary")
    public ModelAndView summary() {
        ModelAndView view = new ModelAndView();
        try {
            Subject subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                view.setViewName("/account/summary");
                return view;
            }
        } catch (Exception e) {
            view.setViewName("redirect:/login");
            return view;
        }
        view.setViewName("redirect:/login");
        return view;
    }
}
