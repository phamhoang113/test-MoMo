package main.dto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class UserDto {
    private BillDto[] bills;
    private PaymentBillDto[] paymentsBills;
    private BigDecimal availableBalance;

    public UserDto() {
        availableBalance = BigDecimal.ZERO;
        bills = new BillDto[]{};
        paymentsBills = new PaymentBillDto[]{};
    }

    public UserDto( BillDto[] bills, PaymentBillDto[] paymentsBills, BigDecimal availableBalance) {
        this.bills = bills;
        this.paymentsBills = paymentsBills;
        this.availableBalance = availableBalance;
    }

    public BillDto[] getBills() {
        return bills;
    }

    public void setBills(BillDto[] bills) {
        Arrays.sort(bills, (a1, a2) -> {
            Date now = new Date();
            boolean a1Overdue = a1.getDueDate().before(now);
            boolean a2Overdue = a2.getDueDate().before(now);

            if (a1Overdue && a2Overdue) {
                // Both are overdue: sort by how long ago they were due (more overdue first)
                return a1.getDueDate().compareTo(a2.getDueDate());
            } else if (!a1Overdue && !a2Overdue) {
                // Both are upcoming: sort by how soon they are due (closer dates first)
                return a1.getDueDate().compareTo(a2.getDueDate());
            } else if (a1Overdue) {
                // a1 is overdue, a2 is upcoming
                return -1;
            } else {
                // a2 is overdue, a1 is upcoming
                return 1;
            }
        });
        this.bills = bills;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public PaymentBillDto[] getPaymentsBills() {
        return paymentsBills;
    }

    public void setPaymentsBills(PaymentBillDto[] paymentsBills) {
        Arrays.sort(paymentsBills, (a1, a2) -> {
            Date now = new Date();
            boolean a1Overdue = a1.getPaymentDate().before(now);
            boolean a2Overdue = a2.getPaymentDate().before(now);

            if (a1Overdue && a2Overdue) {
                return a1.getPaymentDate().compareTo(a2.getPaymentDate());
            } else if (!a1Overdue && !a2Overdue) {
                return a1.getPaymentDate().compareTo(a2.getPaymentDate());
            } else if (a1Overdue) {
                return -1;
            } else {
                return 1;
            }
        });
        this.paymentsBills = paymentsBills;
    }
}
