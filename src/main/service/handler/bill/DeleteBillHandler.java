package main.service.handler.bill;

import main.dto.BillDto;
import main.dto.UserDto;
import main.exception.ErrorInputException;
import main.request.bill.DeleteBillRequest;
import main.service.BaseHandler;
import main.service.BillService;
import main.service.UtilService;

public class DeleteBillHandler implements BaseHandler<DeleteBillRequest> {
    @Override
    public void execute(UserDto userDto, DeleteBillRequest request) throws ErrorInputException {
        try {
            BillDto[] billDtos = userDto.getBills();
            long billId = Long.parseLong(request.getParams()[1]);
            BillService.validateBillExistence(billDtos, billId);
            userDto.setBills(UtilService.removeBillById(billDtos, billId));
            System.out.printf("Delete bill %s successfully%n", billId);
        } catch (ErrorInputException e) {
            throw e;
        } catch (Exception e) {
            throw new ErrorInputException("Format delete bill is: \"DELETE_BILL Bill_id\"");
        }
    }
}
