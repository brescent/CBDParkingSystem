package com.project.service;

import com.project.entity.FrontcomplaintEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface IComplaintService {
    public  void  addComplanit(FrontcomplaintEntity frontcomplaintEntity);
    public void  delComplaint(int id);
    public FrontcomplaintEntity selComplaint(int id);
    public List<Map> getAllComplaint();
    public void updateById(int id ,int state);
    public int getComplaintNum(int id);
    public  Map getComplaintById(int id);
}
