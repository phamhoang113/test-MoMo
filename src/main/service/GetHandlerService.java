package main.service;

import main.exception.ErrorInputException;
import main.request.BaseRequest;
import main.service.handler.CashInHandler;
import main.service.handler.GetListBillPaymentHandler;
import main.service.handler.SchedulePaymentHandler;
import main.service.handler.bill.*;

public class GetHandlerService {
    private static final String SPLIT = " ";

    public static BaseHandler getHandler(BaseRequest baseRequest) throws ErrorInputException {
        switch (baseRequest.getPrefixRequest()) {
            case EXIT -> {
                System.out.println("Good bye!");
                System.exit(0);
            }

            case CREATE_BILL -> {
                return new CreateBillHandler();
            }

            case DELETE_BILL -> {
                return new DeleteBillHandler();
            }

            case UPDATE_BILL -> {
                return new UpdateBillHandler();
            }

            case LIST_BILL -> {
                return new GetListBillHandler();
            }

            case DUE_DATE -> {
                return new GetBillDueDateHandler();
            }

            case PAY_BILL -> {
                return new PayBillHandler();
            }

            case SEARCH_BILL_BY_PROVIDER -> {
                return new SearchBillByProviderHandler();
            }

            case CASH_IN -> {
                return new CashInHandler();
            }

            case LIST_PAYMENT -> {
                return new GetListBillPaymentHandler();
            }

            case SCHEDULE -> {
                return new SchedulePaymentHandler();
            }
        }
        throw new ErrorInputException("Sorry! System Error");
    }
}
