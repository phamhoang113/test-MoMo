package main.request.bill;

import main.enumerate.TypeInputEnum;
import main.request.BaseRequest;

public class GetListBillRequest extends BaseRequest {

    public GetListBillRequest() {}

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.LIST_BILL;
    }
}
