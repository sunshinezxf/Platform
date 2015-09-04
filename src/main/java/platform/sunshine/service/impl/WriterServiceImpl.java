package platform.sunshine.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.sunshine.dao.WriterDao;
import platform.sunshine.form.LoginForm;
import platform.sunshine.form.RegisterForm;
import platform.sunshine.model.Account;
import platform.sunshine.service.WriterService;
import platform.sunshine.utils.CommonValue;
import platform.sunshine.utils.IDGenerator;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/8/29.
 */
@Service
public class WriterServiceImpl implements WriterService {
    private Logger logger = LoggerFactory.getLogger(WriterServiceImpl.class);

    @Autowired
    private WriterDao writerDao;

    @Override
    public ResultData createWriter(RegisterForm form) {
        ResultData result = new ResultData();
        Account account = new Account(form);
        String tempId = IDGenerator.generate(CommonValue.ID_LENGTH);
        ResponseCode response;
        while (true) {
            Account params = new Account();
            params.setAccountId(tempId);
            response = writerDao.queryWriter(params).getResponseCode();
            if (response == ResponseCode.RESPONSE_NULL) {
                account.setAccountId(tempId);
                break;
            } else if (response == ResponseCode.RESPONSE_ERROR) {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
                result.setData("Error occurred when creating account.");
                break;
            } else {
                logger.debug("Prepared account id: " + tempId + "already exists, generate another one.¬");
                tempId = IDGenerator.generate(CommonValue.ID_LENGTH);
            }
        }
        if (response == ResponseCode.RESPONSE_NULL) {
            logger.debug("Create account with id: " + tempId);
            ResultData data = writerDao.insertWriter(account);
            if (data.getResponseCode() == ResponseCode.RESPONSE_OK) {
                result.setData(data.getData());
                result.setDescription("Create account operation success.");
            } else if (data.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
                result.setDescription("Create account operation failure.");
            }
        }
        return result;
    }

    @Override
    public ResultData queryAccountByEmail(String email) {
        ResultData result = new ResultData();
        Account params = new Account();
        params.setEmail(email);
        ResultData data = writerDao.queryWriter(params);
        if (data.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setData(data.getData());
        } else if (data.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
        }
        return result;
    }

    @Override
    public ResultData login(LoginForm form) {
        ResultData result = new ResultData();
        Account account = new Account(form);
        Account params = new Account();
        params.setEmail(account.getEmail());
        ResultData data = writerDao.queryWriter(params);
        if (data.getResponseCode() == ResponseCode.RESPONSE_OK) {
            Account vo = (Account) data.getData();
            if (account.getPassword().equals(vo.getPassword())) {
                result.setData(vo);
            } else {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
                result.setDescription("用户名、密码错误");
            }
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("用户名、密码不存在");
        }
        return result;
    }
}
