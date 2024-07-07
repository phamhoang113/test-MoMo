package main.request;

import main.enumerate.TypeInputEnum;

public class ExitRequest extends BaseRequest{

    public ExitRequest() {}

    @Override
    public TypeInputEnum getPrefixRequest() {
        return TypeInputEnum.EXIT;
    }
}
