package main.request.bill;

import main.enumerate.TypeInputEnum;
import main.request.BaseRequest;

public class GetBillDueDateRequest extends BaseRequest {

    public GetBillDueDateRequest() {}

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.DUE_DATE;
    }
}
