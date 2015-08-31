package platform.sunshine.service;

import platform.sunshine.form.RegisterForm;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/8/29.
 */
public interface WriterService {
    public ResultData createWriter(RegisterForm form);
}
