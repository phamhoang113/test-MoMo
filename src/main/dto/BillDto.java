package main.dto;

import main.enumerate.BillStatusEnum;

import java.math.BigDecimal;
import java.util.Date;

public class BillDto {

    private static long sequence = 1;

    public static synchronized long getNextSequence() {
        return sequence++;
    }

    private long id;
    private ServiceDto service;
    private BigDecimal amount;
    private Date dueDate;
    private BillStatusEnum status;
    private ProviderDto provider;

    public BillDto() {}

    public BillDto(ServiceDto service, BigDecimal amount, Date duaDate, ProviderDto provider) {
        this.id = getNextSequence();
        this.service = service;
        this.amount = amount;
        this.dueDate = duaDate;
        this.status = BillStatusEnum.NOT_PAID;
        this.provider = provider;
    }

    public long getId() {
        return id;
    }


    public ServiceDto getService() {
        return service;
    }

    public void setService(ServiceDto service) {
        this.service = service;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BillStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BillStatusEnum status) {
        this.status = status;
    }

    public ProviderDto getProvider() {
        return provider;
    }

    public void setProvider(ProviderDto provider) {
        this.provider = provider;
    }
}
