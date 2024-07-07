package main.service.handler.bill;

import main.dto.BillDto;
import main.dto.PaymentBillDto;
import main.dto.UserDto;
import main.enumerate.BillStatusEnum;
import main.enumerate.PaymentStatusEnum;
import main.exception.ErrorInputException;
import main.request.bill.PayBillRequest;
import main.service.BaseHandler;
import main.service.UtilService;

import java.util.Date;

public class PayBillHandler implements BaseHandler<PayBillRequest> {
    @Override
    public void execute(UserDto userDto, PayBillRequest request) throws ErrorInputException {

        BillDto[] billDtos = userDto.getBills();
        if (billDtos.length == 0) {
            throw new ErrorInputException("Sorry! Not found a bill with such id");
        }

         for(String s: request.getParams()){
             if(!s.equalsIgnoreCase("pay")){
                 try {
                     long billId = Long.parseLong(s);
                     boolean isHaveInvoice = false;
                     for(BillDto b: billDtos){
                         if(b.getId() == billId){
                             isHaveInvoice = true;
                            if(userDto.getAvailableBalance().compareTo(b.getAmount())>=0){
                                userDto.setAvailableBalance(userDto.getAvailableBalance().subtract(b.getAmount()));
                                b.setStatus(BillStatusEnum.PAID);
                                updateInforPayment(userDto, b);
                            }
                            else{
                                System.out.printf("Sorry! Not enough fund pay bill: %s%n", billId);
                            }
                         }
                     }
                     if(!isHaveInvoice){
                         System.out.printf("Sorry! Not found a bill with such id: %s%n", billId);
                     }
                 }
                 catch(Exception e){
                     throw new ErrorInputException("Format delete bill is: \"PAY List Bill_Id\"");
                 }

             }
         }
    }

    private void updateInforPayment(UserDto userDto, BillDto b) {
        boolean isHaveInvoiceInPayment = false;
        for(PaymentBillDto paymentBillDto: userDto.getPaymentsBills()){
            if(paymentBillDto.getBill().getId() == b.getId()){
                isHaveInvoiceInPayment = true;
                paymentBillDto.setStatus(PaymentStatusEnum.PROCESSED);
                paymentBillDto.setPaymentDate(new Date());
                break;
            }
        }
        if(isHaveInvoiceInPayment){
            PaymentBillDto paymentBillDto = new PaymentBillDto(b.getAmount(), new Date(), PaymentStatusEnum.PROCESSED, b);
           userDto.setPaymentsBills(UtilService.addElement(userDto.getPaymentsBills(), paymentBillDto, PaymentBillDto.class));
        }
    }
}
