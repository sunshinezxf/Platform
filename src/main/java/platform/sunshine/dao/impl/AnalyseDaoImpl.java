package platform.sunshine.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import platform.sunshine.dao.AnalyseDao;
import platform.sunshine.model.Behavior;
import platform.sunshine.utils.BaseDao;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/10/5.
 */
@Repository
public class AnalyseDaoImpl extends BaseDao implements AnalyseDao {
    private Logger logger = LoggerFactory.getLogger(AnalyseDaoImpl.class);

    @Override
    public ResultData insertOperation(Behavior behavior) {
        ResultData result = new ResultData();
        try {
            sqlSession.insert("behavior.insertBehavior", behavior);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            logger.debug(e.getMessage());
        } finally {
            return result;
        }
    }
}
