package com.lovo.back.entity;

import java.util.List;

public class PaginationBean<T> {

    private int  currentPage;
    private int pageSize;
    private  int total;
private int count;
    private List<T> dataList;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public void setCount(int count){
        this.count=count;
    }
    public int getCount(){
       return count;
    }
}
