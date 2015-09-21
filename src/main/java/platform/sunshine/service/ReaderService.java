package platform.sunshine.service;

import platform.sunshine.model.Reader;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/9/21.
 */
public interface ReaderService {
    public ResultData createReader(Reader reader);

    public ResultData queryReader(Reader reader);
}
