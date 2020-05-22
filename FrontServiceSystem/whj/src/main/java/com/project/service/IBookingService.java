package com.project.service;

import com.project.entity.FrontOrderEntity;

/**
 * 预定车位业务层
 */
public interface IBookingService {

    void saveOrder(FrontOrderEntity frontOrderEntity);
}
