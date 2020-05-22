package com.project.vo;

public  class ShowDealTwo {

    public static  class showDealTwoVo {
        /**
         * 用户id
         */
        private int userId;
        /**
         * 交易id
         */
        private int dealId;
        /**
         * 车位地址
         */
        private String stallAddress;
        /**
         * 身份证号码
         */
        private String idnum;
        /**
         * 交易价格
         */
        private float dealPrice;
        /**
         * 职业
         */
        private String profession;
        /**
         * 真实姓名
         */
        private String realName;
        /**
         * 用户名
         */
        private String userName;
        /**
         * 车位编号
         */
        private String stallNum;

        public showDealTwoVo() {
        }

        public showDealTwoVo(int userId, int dealId, String stallAddress, String idnum, float dealPrice, String profession, String realName, String userName, String stallNum) {
            this.userId = userId;
            this.dealId = dealId;
            this.stallAddress = stallAddress;
            this.idnum = idnum;
            this.dealPrice = dealPrice;
            this.profession = profession;
            this.realName = realName;
            this.userName = userName;
            this.stallNum = stallNum;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getDealId() {
            return dealId;
        }

        public void setDealId(int dealId) {
            this.dealId = dealId;
        }

        public String getStallAddress() {
            return stallAddress;
        }

        public void setStallAddress(String stallAddress) {
            this.stallAddress = stallAddress;
        }

        public String getIdnum() {
            return idnum;
        }

        public void setIdnum(String idnum) {
            this.idnum = idnum;
        }

        public float getDealPrice() {
            return dealPrice;
        }

        public void setDealPrice(float dealPrice) {
            this.dealPrice = dealPrice;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getStallNum() {
            return stallNum;
        }

        public void setStallNum(String stallNum) {
            this.stallNum = stallNum;
        }
    }

}
