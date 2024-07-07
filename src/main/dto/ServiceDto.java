package main.dto;

import main.enumerate.ServiceStatusEnum;

public class ServiceDto {
    private long id;
    private String name;
    private ServiceStatusEnum status;

    public ServiceDto() {}

    public ServiceDto(long id, String name, ServiceStatusEnum status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ServiceStatusEnum status) {
        this.status = status;
    }
}
