package platform.sunshine.dao;

import platform.sunshine.model.Account;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/8/29.
 */
public interface WriterDao {

    public ResultData insertWriter(Account account);

    public ResultData queryWriter(Account account);
}
