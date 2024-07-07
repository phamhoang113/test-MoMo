package main.dto;

import main.enumerate.ProviderStatusEnum;

import java.util.Objects;

public class ProviderDto {
    private long id;
    private String name;
    private ProviderStatusEnum status;

    public ProviderDto() {}

    public ProviderDto(long id, String name, ProviderStatusEnum status) {
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

    public ProviderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ProviderStatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProviderDto that = (ProviderDto) o;
        return id == that.id && Objects.equals(name, that.name);
    }

}
