package platform.sunshine.dao;

import platform.sunshine.model.Reader;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/9/21.
 */
public interface ReaderDao {
    public ResultData insertReader(Reader reader);

    public ResultData queryReader(Reader reader);
}
