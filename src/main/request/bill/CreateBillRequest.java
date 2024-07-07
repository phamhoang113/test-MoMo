package main.request.bill;

import main.enumerate.TypeInputEnum;
import main.request.BaseRequest;

public class CreateBillRequest extends BaseRequest {

    public CreateBillRequest(String[] params) {
        super(params);
    }

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.CREATE_BILL;
    }
}
