package main.service.handler;

import main.dto.UserDto;
import main.exception.ErrorInputException;
import main.request.CashInRequest;
import main.service.BaseHandler;

import java.math.BigDecimal;

public class CashInHandler implements BaseHandler<CashInRequest> {

    @Override
    public void execute(UserDto userDto, CashInRequest request) throws ErrorInputException {
        try{
            BigDecimal amount = new BigDecimal(request.getParams()[1]);
            userDto.setAvailableBalance(userDto.getAvailableBalance().add(amount));
            System.out.printf("Your available balance: %s%n", userDto.getAvailableBalance().toPlainString());
        }
        catch(Exception e){
            throw new ErrorInputException("Format cash in is: \"CASH_IN amount\"");
        }
    }
}
