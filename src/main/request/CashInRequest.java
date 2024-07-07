package main.request;

import main.enumerate.TypeInputEnum;


public class CashInRequest extends BaseRequest{

    public CashInRequest(String[] params) {
        super(params);
    }

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.CASH_IN;
    }
}
