package platform.sunshine.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import platform.sunshine.dao.DealDao;
import platform.sunshine.model.Deal;
import platform.sunshine.utils.BaseDao;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/9/21.
 */
@Repository
public class DealDaoImpl extends BaseDao implements DealDao {
    private Logger logger = LoggerFactory.getLogger(DealDaoImpl.class);

    @Override
    public ResultData insertDeal(Deal deal) {
        ResultData result = new ResultData();
        try {
            sqlSession.insert("deal.insertDeal", deal);
            result.setData(queryDeal(deal));
        } catch (Exception e) {
            logger.debug(e.getMessage());
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        } finally {
            return result;
        }
    }

    @Override
    public ResultData queryDeal(Deal deal) {
        ResultData result = new ResultData();
        try {
            Deal vo = sqlSession.selectOne("deal.queryDeal", deal);
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
