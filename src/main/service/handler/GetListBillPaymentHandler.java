package main.service.handler;

import main.dto.PaymentBillDto;
import main.dto.UserDto;
import main.request.GetListPaymentRequest;
import main.service.BaseHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GetListBillPaymentHandler implements BaseHandler<GetListPaymentRequest> {

    private static final String PATTERN_LINE = "%-15s %-15s %-15s %-15s %s%n";


    @Override
    public void execute(UserDto userDto, GetListPaymentRequest request) {
        System.out.printf(PATTERN_LINE, "No. ", "Amount", "Payment Date", "Status", "Bill Id");
        int count = 1;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for(PaymentBillDto paymentBillDto: userDto.getPaymentsBills()){
            System.out.printf(PATTERN_LINE, count++, paymentBillDto.getAmount().toPlainString(),
                    dateFormat.format(paymentBillDto.getPaymentDate()), paymentBillDto.getStatus().getStatus(),
                    paymentBillDto.getBill().getId());
        }
    }
}
