package com.project.service.impl;

import com.project.dao.DealDao;
import com.project.dao.SellDao;
import com.project.dao.StallDealDao;
import com.project.dao.StallDealDaoTwo;
import com.project.dto.ShowDealDto;
import com.project.entity.FrontDealEntity;
import com.project.entity.FrontStallEntity;
import com.project.service.ISellService;
import com.project.utils.EntityUtils;
import com.project.vo.ShowDealTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "SellService")
public class SellServiceImpl implements ISellService {

    @Autowired
    private SellDao sellDao;
    @Autowired
    private DealDao dealDao;
    @Autowired
    private StallDealDao stallDealDao;
    @Autowired
    private StallDealDaoTwo stallDealDaoTwo;

    /**
     * 保存车位信息
     * @param frontStallEntity
     */
    @Override
    public void saveReleaseSell(FrontStallEntity frontStallEntity) {
        sellDao.save(frontStallEntity);
    }

    /**
     * 保存交易信息
     * @param frontDealEntity
     */
    @Override
    public void saveDealInfo(FrontDealEntity frontDealEntity) {
        dealDao.save(frontDealEntity);
    }

    @Override
    public List<FrontDealEntity> getAllByDealEndDate() {
        return dealDao.getAllByDealEndDate();
    }

    @Override
    public List<ShowDealTwo.showDealTwoVo>getDealById(int id) {
        List<Object[]> objects = dealDao.getDealById(id);
        return EntityUtils.castEntity(objects, ShowDealTwo.showDealTwoVo.class, new ShowDealTwo.showDealTwoVo());
    }

    @Override
    public List<ShowDealDto> getAllDeal() {
        return stallDealDao.getAllDeal();
    }

    @Override
    public List<ShowDealTwo.showDealTwoVo> getAllDealTwo() {
        List<Object[]> objects = stallDealDaoTwo.getAllDealTwo();
        return EntityUtils.castEntity(objects, ShowDealTwo.showDealTwoVo.class,new ShowDealTwo.showDealTwoVo());
    }

    @Override
    public FrontDealEntity getdealByid2(int id) {
        return dealDao.getDealById2(id);
    }


}
