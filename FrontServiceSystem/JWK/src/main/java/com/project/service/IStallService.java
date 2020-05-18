package com.project.service;

import com.project.entity.FrontOrderEntity;
import com.project.entity.FrontStallEntity;
import com.project.entity.FrontUserInfoEntity;

public interface IStallService {
    public  void  addStall(FrontStallEntity frontStallEntity);
    public void  delStall(int id);
    public void  updateStall(FrontStallEntity frontStallEntity);
    public FrontStallEntity  selStall(int id);
}
