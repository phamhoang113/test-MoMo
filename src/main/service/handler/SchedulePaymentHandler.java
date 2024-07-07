package main.service.handler;

import main.dto.BillDto;
import main.dto.PaymentBillDto;
import main.dto.UserDto;
import main.enumerate.PaymentStatusEnum;
import main.exception.ErrorInputException;
import main.request.SchedulePaymentRequest;
import main.service.BaseHandler;
import main.service.UtilService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SchedulePaymentHandler implements BaseHandler<SchedulePaymentRequest> {

    @Override
    public void execute(UserDto userDto, SchedulePaymentRequest request) throws ErrorInputException {
        try{
            BillDto[] billDtos = userDto.getBills();
            if(billDtos.length == 0){
                throw new ErrorInputException("Sorry! Not found a bill with such id");
            }

            long billId = Long.parseLong(request.getParams()[1]);
            BillDto billPayment = new BillDto();
            boolean isHaveInvoice = false;
            for(BillDto billDto : billDtos){
                if(billDto.getId() == billId){
                    billPayment = billDto;
                    isHaveInvoice = true;
                    break;
                }
            }
            if(!isHaveInvoice){
                throw new ErrorInputException("Sorry! Not found a bill with such id");
            }

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date datePayment = formatter.parse(request.getParams()[2]);
            if(datePayment.compareTo(new Date())<=0){
                throw new ErrorInputException("Sorry! Schedule date is less than now");
            }
            PaymentBillDto paymentBillDto = new PaymentBillDto(billPayment.getAmount(), datePayment, PaymentStatusEnum.PENDING, billPayment);
            userDto.setPaymentsBills(UtilService.addElement(userDto.getPaymentsBills(), paymentBillDto, PaymentBillDto.class));
            System.out.printf("Payment for bill id %s is scheduled on %s%n", billId, request.getParams()[2]);
        }
        catch (ErrorInputException e){
            throw e;
        }
        catch(Exception e){
            throw new ErrorInputException("Format schedule payment is: \"SCHEDULE Bill_id Date(format dd/MM/yyyy)\"");
        }
    }
}
