package platform.sunshine.service.impl;

import org.springframework.stereotype.Service;
import platform.sunshine.form.RegisterForm;
import platform.sunshine.service.WriterService;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/8/29.
 */
@Service
public class WriterServiceImpl implements WriterService {

    public ResultData createWriter(RegisterForm form) {
        ResultData result = new ResultData();

        return result;
    }
}
