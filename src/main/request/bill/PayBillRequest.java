package main.request.bill;

import main.enumerate.TypeInputEnum;
import main.request.BaseRequest;


public class PayBillRequest extends BaseRequest {

    public PayBillRequest(String[] params) {
        super(params);
    }

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.PAY_BILL;
    }
}
