package main.service;

import main.dto.BillDto;
import main.dto.UserDto;
import main.exception.ErrorInputException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BillService {

    private static final String PATTERN_LINE = "%-15s %-15s %-15s %-15s %-15s %s%n";

    public static void validateBillExistence(BillDto[] billDtos, long billId) throws ErrorInputException {
        if (billDtos.length == 0) {
            throw new ErrorInputException("Sorry! Not found a bill with such id");
        }

        boolean isHaveInvoice = false;
        for (BillDto billDto : billDtos) {
            if (billDto.getId() == billId) {
                isHaveInvoice = true;
                break;
            }
        }
        if (!isHaveInvoice) {
            throw new ErrorInputException("Sorry! Not found a bill with such id");
        }
    }

    public static void printBills(BillDto[] bills) {
        System.out.printf(PATTERN_LINE, "Bill No.", "Type", "Amount", "Due Date", "Status", "Provider");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (BillDto billDto : bills) {
            System.out.printf(PATTERN_LINE, billDto.getId(), billDto.getService().getName(),
                    billDto.getAmount().toPlainString(), dateFormat.format(billDto.getDueDate()),
                    billDto.getStatus(),
                    billDto.getProvider().getName());
        }
    }

    public static BillDto findBillById(BillDto[] billDtos, long billId) throws ErrorInputException {
        for (BillDto billDto : billDtos) {
            if (billDto.getId() == billId) {
                return billDto;
            }
        }
        throw new ErrorInputException("Sorry! Not found a bill with such id");
    }
}
