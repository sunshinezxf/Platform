package platform.sunshine.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.sunshine.dao.DealDao;
import platform.sunshine.model.Deal;
import platform.sunshine.service.DealService;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/9/21.
 */
@Service
public class DealServiceImpl implements DealService {
    private Logger logger = LoggerFactory.getLogger(DealServiceImpl.class);

    @Autowired
    private DealDao dealDao;

    @Override
    public ResultData createDealRecord(Deal deal) {
        ResultData result = new ResultData();
        ResultData data = dealDao.insertDeal(deal);
        if (data.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setData(data.getData());
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
        }
        return result;
    }

    @Override
    public ResultData queryDealRecord(Deal deal) {
        ResultData result = new ResultData();
        ResultData data = dealDao.queryDeal(deal);
        if (data.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setData(result);
        } else if (data.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
        }
        return result;
    }
}
