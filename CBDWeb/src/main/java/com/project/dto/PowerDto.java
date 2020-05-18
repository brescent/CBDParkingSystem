package com.project.dto;

public class PowerDto {
    private String powerName;

    public PowerDto() {
    }



    public PowerDto(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
}
