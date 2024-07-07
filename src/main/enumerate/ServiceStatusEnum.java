package main.enumerate;

public enum ServiceStatusEnum {
    ACTIVE("1"),
    INACTIVE("0"),
    INTERRUPT("2");
    private final String status;

    ServiceStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
