package com.project.vo;



public class UserVo {
    /**个人用户id*/
    private String realName;

    /**个人用户职业描述*/
    private String jobInfo;

    /**个人用户邮箱*/
    private String email;

    /**个人用户家庭住址*/

    private String homeAddress;

    /**个人用户身份证号*/

    private String  cardNum;

    /**个人用户电话号码*/

    private String phone;

    /**用户登录名*/
    private String loginName;
    /**用户密码*/

    private String pwd;

    public UserVo() {
    }

    public UserVo(String realName, String jobInfo, String email, String homeAddress, String cardNum, String phone, String loginName, String pwd) {
        this.realName = realName;
        this.jobInfo = jobInfo;
        this.email = email;
        this.homeAddress = homeAddress;
        this.cardNum = cardNum;
        this.phone = phone;
        this.loginName = loginName;
        this.pwd = pwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
