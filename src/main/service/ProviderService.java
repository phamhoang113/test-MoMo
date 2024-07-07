package main.service;

import main.dto.ProviderDto;
import main.enumerate.ProviderStatusEnum;

public class ProviderService {

    private static ProviderDto[] providers;

    public static void loadProviders() {
        providers = new ProviderDto[3];
        providers[0] = new ProviderDto(1, "EVN_HCMC", ProviderStatusEnum.ACTIVE);
        providers[1] = new ProviderDto(2, "SAVACO_HCMC", ProviderStatusEnum.ACTIVE);
        providers[2] = new ProviderDto(3, "VNPT", ProviderStatusEnum.ACTIVE);
    }

    public static ProviderDto getProviderDto(String provider) {
        for(ProviderDto providerDto: providers){
            if(providerDto.getStatus()== ProviderStatusEnum.ACTIVE&& providerDto.getName().equalsIgnoreCase(provider)){
                return providerDto;
            }
        }
        return null;
    }
}
