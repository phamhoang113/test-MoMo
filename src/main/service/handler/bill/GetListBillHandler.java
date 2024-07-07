package main.service.handler.bill;

import main.dto.UserDto;
import main.request.bill.GetListBillRequest;
import main.service.BaseHandler;
import main.service.BillService;

public class GetListBillHandler implements BaseHandler<GetListBillRequest> {

    @Override
    public void execute(UserDto userDto, GetListBillRequest request) {
        BillService.printBills(userDto.getBills());
    }
}
