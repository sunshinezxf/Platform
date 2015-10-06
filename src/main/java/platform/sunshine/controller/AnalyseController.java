package platform.sunshine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import platform.sunshine.form.OperationForm;
import platform.sunshine.model.Behavior;
import platform.sunshine.service.AnalyseService;
import platform.sunshine.utils.Tools;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sunshine on 15/10/5.
 */
@RestController
@RequestMapping("/analyse")
public class AnalyseController {
    private Logger logger = LoggerFactory.getLogger(AnalyseController.class);

    @Autowired
    private AnalyseService analyseService;

    @RequestMapping(method = RequestMethod.POST, value = "/operate")
    @ResponseBody
    public String operate(OperationForm operationForm, HttpServletRequest request) {
        String ip = Tools.getIP(request);
        Behavior behavior = new Behavior(operationForm, ip);
        ResultData result = analyseService.createReaderOperation(behavior);
        return result.getResponseCode() == ResponseCode.RESPONSE_OK ? "success" : "failure";
    }
}
