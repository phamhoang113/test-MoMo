package main.service.handler.bill;

import main.dto.BillDto;
import main.dto.ProviderDto;
import main.dto.UserDto;
import main.exception.ErrorInputException;
import main.request.bill.SearchBillByProviderRequest;
import main.service.BaseHandler;
import main.service.BillService;
import main.service.ProviderService;
import java.util.Arrays;

public class SearchBillByProviderHandler implements BaseHandler<SearchBillByProviderRequest> {


    @Override
    public void execute(UserDto userDto, SearchBillByProviderRequest request) throws ErrorInputException {
        try {
            String providerName = request.getParams()[1];
            BillDto[] bills = findBillsByProvider(userDto, providerName);
            BillService.printBills(bills);
        } catch (ErrorInputException e) {
            throw e;
        } catch (Exception e) {
            throw new ErrorInputException("Format search by provider is: \"SEARCH_BILL_BY_PROVIDER provider\"");
        }
    }

    private BillDto[] findBillsByProvider(UserDto userDto, String providerName) throws ErrorInputException {
        ProviderDto providerDto = ProviderService.getProviderDto(providerName);
        if (providerDto == null) {
            throw new ErrorInputException("Sorry! Not found a provider with such name");
        }

        BillDto[] bills = userDto.getBills();
        BillDto[] result = new BillDto[bills.length];
        int count = 0;
        for (BillDto billDto : bills) {
            if (billDto.getProvider().equals(providerDto)) {
                result[count++] = billDto;
            }
        }

        if (count == 0) {
            throw new ErrorInputException("Sorry! Not found any bill with provider: " + providerName);
        }

        return Arrays.copyOf(result, count);
    }
}
