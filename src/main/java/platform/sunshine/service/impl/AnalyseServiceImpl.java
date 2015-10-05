package platform.sunshine.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.sunshine.dao.AnalyseDao;
import platform.sunshine.model.Behavior;
import platform.sunshine.service.AnalyseService;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/10/5.
 */
@Service
public class AnalyseServiceImpl implements AnalyseService {
    private Logger logger = LoggerFactory.getLogger(AnalyseServiceImpl.class);

    @Autowired
    private AnalyseDao analyseDao;

    public ResultData createReaderOperation(Behavior behavior) {
        ResultData result = new ResultData();
        ResultData data = analyseDao.insertOperation(behavior);
        try {
            if (data.getResponseCode() == ResponseCode.RESPONSE_OK) {
                result.setResponseCode(ResponseCode.RESPONSE_OK);
            } else {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
        } finally {
            return result;
        }
    }
}
