package main.request;

import main.enumerate.TypeInputEnum;

public abstract class BaseRequest {
    protected String[] params;

    public BaseRequest() {}

    public BaseRequest(String[] params) {
        this.params = params;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public abstract TypeInputEnum getPrefixRequest();
}
