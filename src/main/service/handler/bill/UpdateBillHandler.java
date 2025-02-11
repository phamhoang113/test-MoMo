package main.service.handler.bill;

import main.dto.BillDto;
import main.dto.ProviderDto;
import main.dto.ServiceDto;
import main.dto.UserDto;
import main.exception.ErrorInputException;
import main.request.bill.UpdateBillRequest;
import main.service.BaseHandler;
import main.service.BillService;
import main.service.ProviderService;
import main.service.ServiceTypeService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateBillHandler implements BaseHandler<UpdateBillRequest> {
    @Override
    public void execute(UserDto userDto, UpdateBillRequest request) throws ErrorInputException {
        try {
            BillDto[] billDtos = userDto.getBills();
            long billId = Long.parseLong(request.getParams()[1]);
            BillService.validateBillExistence(billDtos, billId);

            BillDto billToUpdate = BillService.findBillById(billDtos, billId);
            updateBillFromRequest(billToUpdate, request);

            System.out.printf("Update bill %s successfully%n", billId);
        } catch (ErrorInputException e) {
            throw e;
        } catch (Exception e) {
            throw new ErrorInputException("Format update bill is: \"UPDATE_BILL bill_id service amount due_date provider\"");
        }
    }

    private void updateBillFromRequest(BillDto billDto, UpdateBillRequest request) throws ErrorInputException {
        try {
            String service = request.getParams()[2];
            BigDecimal amount = new BigDecimal(request.getParams()[3]);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dueDate = formatter.parse(request.getParams()[4]);
            String provider = request.getParams()[5];

            ServiceDto serviceDto = ServiceTypeService.findService(service);
            if (serviceDto == null) {
                throw new ErrorInputException("Service not found");
            }

            ProviderDto providerDto = ProviderService.getProviderDto(provider);
            if (providerDto == null) {
                throw new ErrorInputException("Provider not found");
            }

            billDto.setService(serviceDto);
            billDto.setProvider(providerDto);
            billDto.setAmount(amount);
            billDto.setDueDate(dueDate);
        }
        catch (ErrorInputException e){
            throw e;
        }
        catch (Exception e) {
            throw new ErrorInputException("Format update bill is: \"UPDATE_BILL bill_id service amount due_date provider\"");
        }
    }
}
