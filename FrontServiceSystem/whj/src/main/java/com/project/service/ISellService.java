package com.project.service;

import com.project.dto.ShowDealDto;
import com.project.entity.FrontDealEntity;
import com.project.entity.FrontStallEntity;
import com.project.vo.ShowDealTwo;

import java.util.List;

public interface ISellService {

     void saveReleaseSell(FrontStallEntity frontStallEntity);

     void saveDealInfo(FrontDealEntity frontDealEntity);

     List<FrontDealEntity> getAllByDealEndDate();

     List<ShowDealTwo.showDealTwoVo> getDealById(int id);

     List<ShowDealDto> getAllDeal();

     List<ShowDealTwo.showDealTwoVo> getAllDealTwo();

     FrontDealEntity getdealByid2(int id);

}
