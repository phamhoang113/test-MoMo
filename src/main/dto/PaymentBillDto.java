package main.dto;

import main.enumerate.PaymentStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentBillDto {
    private BigDecimal amount;
    private Date paymentDate;
    private PaymentStatusEnum status;
    private BillDto bill;

    public PaymentBillDto() {}

    public PaymentBillDto(BigDecimal amount, Date paymentDate, PaymentStatusEnum status, BillDto bill) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
        this.bill = bill;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }

    public BillDto getBill() {
        return bill;
    }

    public void setBill(BillDto bill) {
        this.bill = bill;
    }
}
