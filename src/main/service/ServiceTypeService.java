package main.service;

import main.dto.ServiceDto;
import main.enumerate.ServiceStatusEnum;

public class ServiceTypeService {
    private static ServiceDto[] services;

    public static void loadServices() {
        services = new ServiceDto[3];
        services[0] = new ServiceDto(1, "ELECTRIC", ServiceStatusEnum.ACTIVE);
        services[1] = new ServiceDto(2, "WATER", ServiceStatusEnum.ACTIVE);
        services[2] = new ServiceDto(3, "INTERNET", ServiceStatusEnum.ACTIVE);
    }

    public static ServiceDto findService(String serviceType) {
        for (ServiceDto service : services) {
            if ((service.getStatus()== ServiceStatusEnum.ACTIVE&& service.getName().equals(serviceType))){
                return service;
            }
        }
        return null;
    }
}
