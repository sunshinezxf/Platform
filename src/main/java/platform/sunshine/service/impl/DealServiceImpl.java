package platform.sunshine.service.impl;

import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.sunshine.dao.DealDao;
import platform.sunshine.model.Deal;
import platform.sunshine.service.DealService;
import platform.sunshine.utils.CommonValue;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public ResultData charge(Deal deal) {
        ResultData result = new ResultData();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("amount", deal.getDealPayment());
        params.put("currency", deal.getCurrency());
        params.put("subject", deal.getSubject());
        params.put("body", deal.getArticle().getTitle());
        params.put("order_no", deal.getOrderNo());
        params.put("channel", deal.getChannel());
        params.put("client_ip", deal.getClientIp());
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", CommonValue.APP_ID);
        params.put("app", app);
        try {
            Pingpp.apiKey = CommonValue.API_KEY;
            Charge charge = Charge.create(params);
            result.setData(charge);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            logger.debug(e.getMessage());
        } finally {
            return result;
        }
    }
}
