package com.project.dto;

import com.lovo.back.entity.OutContractAndStall;

import java.sql.Date;
import java.util.Set;

public class OutContractDto {

    /**
     * 外部合约实体类  cbd系统与其他平台签订的合约
     */


        /*外部合同主键 唯一标志*/

        private int id;
        /*外部合约编号*/

        private String outContractNo;
        /*合同单位*/

        private  String unit;
        /*双方联系人*/

        private String bothParties;
        /*对方联系人*/

        private String  linkMan;
        /*合同生效日期*/
        private Date startDate;
        /*合同失效日期*/
        private  Date  endDate;
        /*成交价格*/
        private  double dealPrice;

        /*合约图片名称*/

        private  String contractImg ;

        /*旧合同编号*/

        private String oldOutContractNo;



        /*合同生效状态*/
        private int state=1;

    private Set<OutContractAndStall> outContractAndStallSet;

        public OutContractDto() {
        }

        public OutContractDto(String outContractNo, String unit, String bothParties, String linkMan, Date startDate, Date endDate, double dealPrice, String contractImg, String oldOutContractNo) {
            this.outContractNo = outContractNo;
            this.unit = unit;
            this.bothParties = bothParties;
            this.linkMan = linkMan;
            this.startDate = startDate;
            this.endDate = endDate;
            this.dealPrice = dealPrice;
            this.contractImg = contractImg;
            this.oldOutContractNo = oldOutContractNo;
        }

    public Set<OutContractAndStall> getOutContractAndStallSet() {
        return outContractAndStallSet;
    }

    public void setOutContractAndStallSet(Set<OutContractAndStall> outContractAndStallSet) {
        this.outContractAndStallSet = outContractAndStallSet;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOutContractNo() {
            return outContractNo;
        }

        public void setOutContractNo(String outContractNo) {
            this.outContractNo = outContractNo;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getBothParties() {
            return bothParties;
        }

        public void setBothParties(String bothParties) {
            this.bothParties = bothParties;
        }

        public String getLinkMan() {
            return linkMan;
        }

        public void setLinkMan(String linkMan) {
            this.linkMan = linkMan;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public double getDealPrice() {
            return dealPrice;
        }

        public void setDealPrice(double dealPrice) {
            this.dealPrice = dealPrice;
        }

        public String getContractImg() {
            return contractImg;
        }

        public void setContractImg(String contractImg) {
            this.contractImg = contractImg;
        }

        public String getOldOutContractNo() {
            return oldOutContractNo;
        }

        public void setOldOutContractNo(String oldOutContractNo) {
            this.oldOutContractNo = oldOutContractNo;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

}
