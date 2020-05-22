package com.lovo.back.dto;

public class StallDto {

    private int id;

    private String stallNo;

    public StallDto() {
    }

    public StallDto(int id, String stallNo) {
        this.id = id;
        this.stallNo = stallNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStallNo() {
        return stallNo;
    }

    public void setStallNo(String stallNo) {
        this.stallNo = stallNo;
    }
}
