package main.service.handler.bill;

import main.dto.BillDto;
import main.dto.ProviderDto;
import main.dto.UserDto;
import main.exception.ErrorInputException;
import main.request.bill.SearchBillByProviderRequest;
import main.service.BaseHandler;
import main.service.ProviderService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SearchBillByProviderHandler implements BaseHandler<SearchBillByProviderRequest> {

    private static final String PATTERN_LINE = "%-15s %-15s %-15s %-15s %-15s %s%n";

    @Override
    public void execute(UserDto userDto, SearchBillByProviderRequest request) throws ErrorInputException {
        try {
            BillDto[] billDtos = userDto.getBills();
            if (billDtos.length == 0) {
                throw new ErrorInputException("Sorry! Not found a bill with such provider");
            }

            String provider = request.getParams()[1];
            ProviderDto providerDto = ProviderService.getProviderDto(provider);
            if(null == providerDto) {
                throw new ErrorInputException("Sorry! Not found a provider with such provider");
            }

            System.out.printf(PATTERN_LINE, "Bill No.", "Type", "Amount", "Due Date", "Status", "Provider");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for(BillDto billDto: userDto.getBills()){
                if(billDto.getProvider().equals(providerDto)) {
                    System.out.printf(PATTERN_LINE, billDto.getId(), billDto.getService().getName(),
                            billDto.getAmount().toPlainString(), dateFormat.format(billDto.getDueDate()),
                            billDto.getStatus(),
                            billDto.getProvider().getName());
                }
            }

        }
        catch (ErrorInputException e){
            throw e;
        }
        catch(Exception e){
            throw new ErrorInputException("Format search by provider is: \"SEARCH_BILL_BY_PROVIDER provider\"");
        }
    }
}
