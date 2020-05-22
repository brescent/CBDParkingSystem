package com.project.dto;

public class StallDto {


    /*车位主键 唯一标志*/

    private int id;

    /*车位地址*/

    private String stallAddress;

    /*车位编号*/

    private String stallNo;
    /*车位状态   0表示空闲  1表示 出租中*/
    private int state;


    /*车位产权图片名称*/
    private String stallImg;

    /*身份证号*/

    private String peopleNo;


    /*车位有效性 0表示无效 1表示有效*/

    private int valid=0;

    public StallDto() {
    }

    public StallDto(int id, String stallAddress, String stallNo, int state, String stallImg, String peopleNo, int valid) {
        this.id = id;
        this.stallAddress = stallAddress;
        this.stallNo = stallNo;
        this.state = state;
        this.stallImg = stallImg;
        this.peopleNo = peopleNo;
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStallAddress() {
        return stallAddress;
    }

    public void setStallAddress(String stallAddress) {
        this.stallAddress = stallAddress;
    }

    public String getStallNo() {
        return stallNo;
    }

    public void setStallNo(String stallNo) {
        this.stallNo = stallNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStallImg() {
        return stallImg;
    }

    public void setStallImg(String stallImg) {
        this.stallImg = stallImg;
    }

    public String getPeopleNo() {
        return peopleNo;
    }

    public void setPeopleNo(String peopleNo) {
        this.peopleNo = peopleNo;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }
}
