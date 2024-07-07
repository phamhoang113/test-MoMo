package main.enumerate;

public enum PaymentStatusEnum {
    PROCESSED("PROCESSED"),
    PENDING("PENDING");
    private final String status;

    PaymentStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}