package platform.sunshine.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import platform.sunshine.dao.WriterDao;
import platform.sunshine.model.Account;
import platform.sunshine.utils.BaseDao;
import platform.sunshine.utils.ResposeCode;
import platform.sunshine.utils.ResultData;
import platform.sunshine.vo.AccountVo;

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
            int row = sqlSession.insert("writer.insertAccount", account);
            if (row > 0) {
                result.setData(queryWriter(account).getData());
            } else {
                result.setResposeCode(ResposeCode.RESPONSE_ERROR);
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            result.setResposeCode(ResposeCode.RESPONSE_ERROR);
        } finally {
            return result;
        }
    }

    @Override
    public ResultData queryWriter(Account account) {
        ResultData result = new ResultData();
        try {
            AccountVo vo = sqlSession.selectOne("queryAccount", account);
            if (vo == null) {
                result.setResposeCode(ResposeCode.RESPONSE_NULL);
            } else {
                result.setData(vo);
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            result.setResposeCode(ResposeCode.RESPONSE_ERROR);
        } finally {
            return result;
        }
    }
}
