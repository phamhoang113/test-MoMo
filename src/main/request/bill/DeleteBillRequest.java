package main.request.bill;

import main.enumerate.TypeInputEnum;
import main.request.BaseRequest;

public class DeleteBillRequest extends BaseRequest {

    public DeleteBillRequest(String[] params) {
        super(params);
    }

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.DELETE_BILL;
    }
}
