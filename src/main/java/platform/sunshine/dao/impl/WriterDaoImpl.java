package platform.sunshine.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import platform.sunshine.dao.WriterDao;
import platform.sunshine.model.Account;
import platform.sunshine.utils.Encryption;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/8/29.
 */
@Repository
public class WriterDaoImpl implements WriterDao {
    private Logger logger = LoggerFactory.getLogger(WriterDaoImpl.class);

    @Override
    public ResultData insertWriter(Account account) {
        ResultData result = new ResultData();
        logger.debug("account.email: " + account.getEmail());
        logger.debug("account.username: " + account.getUsername());
        logger.debug("account.encoded_password: " + account.getPassword());
        logger.debug("account.decoded_password: " + Encryption.desDecode(account.getPassword(), account.getEmail()));
        return result;
    }
}
