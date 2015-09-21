package platform.sunshine.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import platform.sunshine.dao.ReaderDao;
import platform.sunshine.model.Reader;
import platform.sunshine.utils.BaseDao;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/9/21.
 */
@Repository
public class ReaderDaoImpl extends BaseDao implements ReaderDao {
    private Logger logger = LoggerFactory.getLogger(ReaderDaoImpl.class);

    @Transactional
    @Override
    public ResultData insertReader(Reader reader) {
        ResultData result = new ResultData();
        try {
            sqlSession.insert("reader.insertReader", reader);
            result.setData(queryReader(reader));
        } catch (Exception e) {
            logger.debug(e.getMessage());
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        } finally {
            return result;
        }
    }

    @Override
    public ResultData queryReader(Reader reader) {
        ResultData result = new ResultData();
        try {
            Reader vo = sqlSession.selectOne("reader.queryReader", reader);
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
