package platform.sunshine.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import platform.sunshine.form.RegisterForm;
import platform.sunshine.model.Account;
import platform.sunshine.service.WriterService;
import platform.sunshine.utils.CommonValue;
import platform.sunshine.utils.Encryption;
import platform.sunshine.utils.IDGenerator;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/8/29.
 */
@Service
public class WriterServiceImpl implements WriterService {
    private Logger logger = LoggerFactory.getLogger(WriterServiceImpl.class);

    public ResultData createWriter(RegisterForm form) {
        ResultData result = new ResultData();
        Account account = new Account(form);
        String tempId = IDGenerator.generate(CommonValue.ID_LENGTH);
        logger.debug("account.email: " + account.getEmail());
        logger.debug("account.username: " + account.getUsername());
        logger.debug("account.encoded_password: " + account.getPassword());
        logger.debug("account.decoded_password: " + Encryption.desDecode(account.getPassword(), account.getEmail()));
        return result;
    }
}
