package main.request.bill;

import main.enumerate.TypeInputEnum;
import main.request.BaseRequest;


public class UpdateBillRequest extends BaseRequest {

    public UpdateBillRequest(String[] params) {
        super(params);
    }

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.UPDATE_BILL;
    }
}
