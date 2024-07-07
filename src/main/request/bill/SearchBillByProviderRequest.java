package main.request.bill;

import main.enumerate.TypeInputEnum;
import main.request.BaseRequest;


public class SearchBillByProviderRequest extends BaseRequest {

    public SearchBillByProviderRequest(String[] params) {
        super(params);
    }

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.SCHEDULE;
    }
}
