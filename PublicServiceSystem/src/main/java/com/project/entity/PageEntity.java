package com.project.entity;

import java.util.List;

/**
 * 分页实体
 * @param <A> 展示数据
 */
public class PageEntity <A>{

    /**展示数据集合*/
    private List<A> list;
    /**每页显示条数*/
    private Integer pageSize;
    /**当前页码*/
    private Integer pageNum;
    /**总页码*/
    private  Integer total;
    /**数据条数*/
    Integer count;

    public PageEntity() {
    }

    public PageEntity(List<A> list, Integer pageSize, Integer pageNum, Integer count) {
        this.list = list;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.count = count;
    }

    public List<A> getList() {
        return list;
    }

    public void setList(List<A> list) {
        this.list = list;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotal() {
        //数据总条数-1 / 数据显示条数为当前总页数
        return (this.count+this.pageSize-1)/this.pageSize;
    }



    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
