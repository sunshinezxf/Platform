package platform.sunshine.controller;

import com.gson.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import platform.sunshine.utils.CommonValue;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sunshine on 15/9/26.
 */
@RestController
public class WechatController {
    private Logger logger = LoggerFactory.getLogger(WechatController.class);


    @RequestMapping(value = "/" + CommonValue.TOKEN, method = RequestMethod.GET)
    public
    @ResponseBody
    String check(HttpServletRequest request) {
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");// 随机数
        String echostr = request.getParameter("echostr");//
        // 验证
        if (Tools.checkSignature(CommonValue.TOKEN, signature, timestamp, nonce)) {
            return echostr;
        }
        return "";
    }
}
