package main.service.handler.bill;

import main.dto.BillDto;
import main.dto.UserDto;
import main.enumerate.BillStatusEnum;
import main.request.bill.GetBillDueDateRequest;
import main.service.BaseHandler;
import main.service.BillService;
import java.util.Arrays;

public class GetBillDueDateHandler implements BaseHandler<GetBillDueDateRequest> {

    @Override
    public void execute(UserDto userDto, GetBillDueDateRequest request) {
        BillService.printBills(Arrays.stream(userDto.getBills()).filter(billDto -> billDto.getStatus()== BillStatusEnum.NOT_PAID||
                billDto.getStatus()== BillStatusEnum.EXPIRE).toArray(BillDto[]::new));

    }
}
