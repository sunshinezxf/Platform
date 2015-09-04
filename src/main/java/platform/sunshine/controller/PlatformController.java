package platform.sunshine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import platform.sunshine.form.LoginForm;
import platform.sunshine.form.RegisterForm;
import platform.sunshine.service.WriterService;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/8/13.
 */
@RestController
public class PlatformController {
    private Logger logger = LoggerFactory.getLogger(PlatformController.class);

    @Autowired
    private WriterService writerService;

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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(RegisterForm registerForm, BindingResult result) {
        ModelAndView view = new ModelAndView();
        if (result.hasErrors()) {
            view.setViewName("register");
            return view;
        }
        ResultData emailExist = writerService.queryAccountByEmail(registerForm.getEmail());
        if (emailExist.getResponseCode() == ResponseCode.RESPONSE_OK) {
            view.setViewName("register");
            return view;
        }
        ResultData data = writerService.createWriter(registerForm);
        view.setViewName("redirect:/login");
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
        logger.debug("username: " + username);
        view.setViewName("redirect:/article/create");
        return view;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/login");
        return view;
    }
}
