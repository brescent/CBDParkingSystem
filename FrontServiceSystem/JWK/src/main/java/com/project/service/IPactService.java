package com.project.service;

import com.project.entity.FrontOrderEntity;
import com.project.entity.FrontPactEntity;
import com.project.entity.FrontUserInfoEntity;

public interface IPactService {
    public  void  addPact(FrontPactEntity frontPactEntity);
    public void  delPact(int id);
    public void  updatePact(FrontPactEntity frontPactEntity);
    public FrontPactEntity  selPact(int id);
}
