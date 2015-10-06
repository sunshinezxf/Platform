package platform.sunshine.service;

import platform.sunshine.form.ChargeForm;
import platform.sunshine.model.Deal;
import platform.sunshine.utils.ResultData;

/**
 * Created by sunshine on 15/9/20.
 */
public interface DealService {
    public ResultData createDealRecord(Deal deal);

    public ResultData queryDealRecord(Deal deal);

    public ResultData charge(ChargeForm form);

    public ResultData updateDealRecord(Deal deal);
}
