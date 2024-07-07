package main.service;

import main.dto.UserDto;
import main.exception.ErrorInputException;
import main.request.BaseRequest;

public interface BaseHandler<I extends BaseRequest> {
    void execute(UserDto userDto, I request) throws ErrorInputException;
}
