package com.project.service;

import com.project.entity.FrontcomplaintEntity;

import java.util.Optional;


public interface IComplaintService {
    public  void  addComplanit(FrontcomplaintEntity frontcomplaintEntity);
    public void  delComplaint(int id);
    public FrontcomplaintEntity selComplaint(int id);
}
