package main.enumerate;

public enum ProviderStatusEnum {
    ACTIVE("1"),
    INACTIVE("0"),
    INTERRUPT("2");
    private final String status;

    ProviderStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}