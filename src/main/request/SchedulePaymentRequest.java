package main.request;

import main.enumerate.TypeInputEnum;


public class SchedulePaymentRequest extends BaseRequest{

    public SchedulePaymentRequest(String[] params) {
        super(params);
    }

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.SCHEDULE;
    }
}
