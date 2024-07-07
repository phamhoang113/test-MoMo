package main.service.handler;

import main.dto.BillDto;
import main.dto.PaymentBillDto;
import main.dto.UserDto;
import main.enumerate.BillStatusEnum;
import main.enumerate.PaymentStatusEnum;
import main.exception.ErrorInputException;
import main.request.SchedulePaymentRequest;
import main.service.BaseHandler;
import main.service.BillService;
import main.service.UtilService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SchedulePaymentHandler implements BaseHandler<SchedulePaymentRequest> {

    @Override
    public void execute(UserDto userDto, SchedulePaymentRequest request) throws ErrorInputException {
        try {
            BillDto billPayment = BillService.findBillById(userDto.getBills(), Long.parseLong(request.getParams()[1]));
            if(billPayment.getStatus()== BillStatusEnum.PAID) {
                throw new ErrorInputException("Bill is paid before");
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date datePayment = formatter.parse(request.getParams()[2]);

            validatePaymentDate(datePayment);

            PaymentBillDto paymentBillDto = new PaymentBillDto(
                    billPayment.getAmount(),
                    datePayment,
                    PaymentStatusEnum.PENDING,
                    billPayment
            );

            userDto.setPaymentsBills(UtilService.addElement(userDto.getPaymentsBills(), paymentBillDto, PaymentBillDto.class));
            System.out.printf("Payment for bill id %s is scheduled on %s%n", billPayment.getId(), request.getParams()[2]);
        } catch (ErrorInputException e) {
            throw e;
        } catch (Exception e) {
            throw new ErrorInputException("Format schedule payment is: \"SCHEDULE Bill_id Date(format dd/MM/yyyy)\"");
        }
    }

    private void validatePaymentDate(Date datePayment) throws ErrorInputException {
        Date today = new Date();
        if (datePayment.compareTo(today)<0) {
            throw new ErrorInputException("Schedule date is less than now");
        }
    }
}
