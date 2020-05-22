package com.project.dto;

public class ParamsDto {

    private String stallAddress;
    private String addressNo;
    private String total;

    private String startNum;

    public ParamsDto() {
    }

    public ParamsDto(String stallAddress, String addressNo, String total, String startNum) {
        this.stallAddress = stallAddress;
        this.addressNo = addressNo;
        this.total = total;
        this.startNum = startNum;
    }

    public String getStallAddress() {
        return stallAddress;
    }

    public void setStallAddress(String stallAddress) {
        this.stallAddress = stallAddress;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStartNum() {
        return startNum;
    }

    public void setStartNum(String startNum) {
        this.startNum = startNum;
    }
}
