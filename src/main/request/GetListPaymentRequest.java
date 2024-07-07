package main.request;

import main.enumerate.TypeInputEnum;

public class GetListPaymentRequest extends BaseRequest{

    public GetListPaymentRequest() {}

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.LIST_PAYMENT;
    }
}
