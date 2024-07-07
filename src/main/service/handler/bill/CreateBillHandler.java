package main.service.handler.bill;

import main.dto.BillDto;
import main.dto.ProviderDto;
import main.dto.ServiceDto;
import main.dto.UserDto;
import main.exception.ErrorInputException;
import main.request.bill.CreateBillRequest;
import main.service.BaseHandler;
import main.service.ProviderService;
import main.service.ServiceTypeService;
import main.service.UtilService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateBillHandler implements BaseHandler<CreateBillRequest> {
    @Override
    public void execute(UserDto userDto, CreateBillRequest request) throws ErrorInputException {
        try {
            BillDto billDto = createBillFromRequest(request);
            userDto.setBills(UtilService.addElement(userDto.getBills(), billDto, BillDto.class));
            System.out.println("Create bill successful");
        } catch (ErrorInputException e) {
            throw e;
        } catch (Exception e) {
            throw new ErrorInputException("Format create bill is: \"CREATE_BILL service amount due_date provider\"");
        }
    }

    private BillDto createBillFromRequest(CreateBillRequest request) throws ErrorInputException {
        try {
            String service = request.getParams()[1];
            BigDecimal amount = new BigDecimal(request.getParams()[2]);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dueDate = formatter.parse(request.getParams()[3]);
            String provider = request.getParams()[4];

            ServiceDto serviceDto = ServiceTypeService.findService(service);
            if (serviceDto == null) {
                throw new ErrorInputException("Service not found");
            }

            ProviderDto providerDto = ProviderService.getProviderDto(provider);
            if (providerDto == null) {
                throw new ErrorInputException("Provider not found");
            }

            return new BillDto(serviceDto, amount, dueDate, providerDto);
        }
        catch (ErrorInputException e){
            throw e;
        }
        catch (Exception e) {
            throw new ErrorInputException("Format create bill is: \"CREATE_BILL service amount due_date provider\"");
        }
    }
}
