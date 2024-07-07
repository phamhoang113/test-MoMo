package main.service.handler.bill;

import main.dto.BillDto;
import main.dto.UserDto;
import main.enumerate.BillStatusEnum;
import main.request.bill.GetBillDueDateRequest;
import main.service.BaseHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GetBillDueDateHandler implements BaseHandler<GetBillDueDateRequest> {

    private static final String PATTERN_LINE = "%-15s %-15s %-15s %-15s %-15s %s%n";

    @Override
    public void execute(UserDto userDto, GetBillDueDateRequest request) {
        System.out.printf(PATTERN_LINE, "Bill No.", "Type", "Amount", "Due Date", "Status", "Provider");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for(BillDto billDto: userDto.getBills()){
            if(billDto.getStatus()== BillStatusEnum.NOT_PAID||
            billDto.getStatus()== BillStatusEnum.EXPIRE) {
                System.out.printf(PATTERN_LINE, billDto.getId(), billDto.getService().getName(),
                        billDto.getAmount().toPlainString(), dateFormat.format(billDto.getDueDate()),
                        billDto.getStatus(),
                        billDto.getProvider().getName());
            }
        }
    }
}
