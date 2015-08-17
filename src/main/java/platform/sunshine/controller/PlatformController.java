package platform.sunshine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import platform.sunshine.form.LoginForm;

/**
 * Created by sunshine on 15/8/13.
 */
@RestController
public class PlatformController {
    private Logger logger = LoggerFactory.getLogger(PlatformController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView view = new ModelAndView();
        view.setViewName("register");
        return view;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView view = new ModelAndView();
        view.setViewName("login");
        return view;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(LoginForm loginForm, BindingResult result) {
        ModelAndView view = new ModelAndView();
        if (result.hasErrors()) {
            view.setViewName("login");
            return view;
        }
        String username = loginForm.getEmail();
        String password = loginForm.getPassword();
        logger.debug("username: " + username);
        logger.debug("password: " + password);
        view.setViewName("/article/create");
        return view;
    }
}
