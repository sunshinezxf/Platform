package platform.sunshine.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.sunshine.dao.WriterDao;
import platform.sunshine.form.RegisterForm;
import platform.sunshine.model.Account;
import platform.sunshine.service.WriterService;
import platform.sunshine.utils.CommonValue;
import platform.sunshine.utils.IDGenerator;
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
        while(true) {

            break;
        }
        account.setAccountId(tempId);
        writerDao.insertWriter(account);
        return result;
    }

    @Override
    public ResultData queryByAccountId(String accountId) {
        ResultData result = new ResultData();
        logger.debug("query whether the account id: " + accountId + " exist or not..");
        return result;
    }
}
