package platform.sunshine.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.sunshine.dao.ReaderDao;
import platform.sunshine.model.Reader;
import platform.sunshine.service.ReaderService;
import platform.sunshine.utils.ResponseCode;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/9/21.
 */
@Service
public class ReaderServiceImpl implements ReaderService {
    private Logger logger = LoggerFactory.getLogger(ReaderServiceImpl.class);
    @Autowired
    private ReaderDao readerDao;

    @Override
    public ResultData createReader(Reader reader) {
        ResultData result = new ResultData();
        ResultData data = readerDao.insertReader(reader);
        if (data.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setData(data.getData());
        } else {
            result.setResponseCode(data.getResponseCode());
        }
        return result;
    }

    @Override
    public ResultData queryReader(Reader reader) {
        ResultData result = new ResultData();
        ResultData data = readerDao.queryReader(reader);
        if (data.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setData(data.getData());
        } else if (data.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
        }
        return result;
    }
}
