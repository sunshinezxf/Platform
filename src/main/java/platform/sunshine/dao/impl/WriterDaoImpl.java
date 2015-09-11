package platform.sunshine.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import platform.sunshine.dao.WriterDao;
import platform.sunshine.model.Account;
import platform.sunshine.utils.BaseDao;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/8/29.
 */
@Repository
public class WriterDaoImpl extends BaseDao implements WriterDao {
    private Logger logger = LoggerFactory.getLogger(WriterDaoImpl.class);

    @Override
    public ResultData insertWriter(Account account) {
        ResultData result = new ResultData();
        try {
            sqlSession.insert("writer.insertAccount", account);
            result.setData(queryWriter(account).getData());
        } catch (Exception e) {
            logger.debug(e.getMessage());
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        } finally {
            return result;
        }
    }

    @Override
    public ResultData queryWriter(Account account) {
        ResultData result = new ResultData();
        try {
            Account vo = sqlSession.selectOne("queryAccount", account);
            if (vo == null) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            } else {
                result.setData(vo);
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        } finally {
            return result;
        }
    }
}
