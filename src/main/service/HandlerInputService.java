package main.service;

import main.enumerate.TypeInputEnum;
import main.exception.ErrorInputException;
import main.request.*;
import main.request.bill.*;

public class HandlerInputService {

    private static final String SPLIT = " ";

    public static BaseRequest getRequest(String input)  throws ErrorInputException {
        String[] inputArray = input.split(SPLIT);
        String typeInput = inputArray[0];
        try {
            TypeInputEnum typeInputEnum = TypeInputEnum.valueOf(typeInput);
            switch (typeInputEnum) {
                case EXIT -> {
                    return new ExitRequest();
                }

                case CREATE_BILL -> {
                    return new CreateBillRequest(inputArray);
                }

                case DELETE_BILL -> {
                    return new DeleteBillRequest(inputArray);
                }

                case UPDATE_BILL -> {
                    return new UpdateBillRequest(inputArray);
                }

                case DUE_DATE -> {
                    return new GetBillDueDateRequest();
                }

                case PAY_BILL -> {
                    return new PayBillRequest(inputArray);
                }

                case LIST_BILL -> {
                    return new GetListBillRequest();
                }

                case SEARCH_BILL_BY_PROVIDER -> {
                    return new SearchBillByProviderRequest(inputArray);
                }

                case CASH_IN -> {
                    return new CashInRequest(inputArray);
                }

                case LIST_PAYMENT -> {
                    return new GetListPaymentRequest();
                }

                case SCHEDULE -> {
                    return new SchedulePaymentRequest(inputArray);
                }

                default -> throw new ErrorInputException("Type input is not support");
            }
        }
        catch (IllegalArgumentException e){
            throw new ErrorInputException("Input is invalid format");
        }
    }
}
