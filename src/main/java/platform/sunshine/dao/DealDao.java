package platform.sunshine.dao;

import platform.sunshine.model.Deal;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/9/21.
 */
public interface DealDao {
    public ResultData insertDeal(Deal deal);

    public ResultData queryDeal(Deal deal);
}
