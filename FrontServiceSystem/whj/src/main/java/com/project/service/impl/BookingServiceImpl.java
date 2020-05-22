package com.project.service.impl;

import com.project.dao.OrderDao;
import com.project.entity.FrontOrderEntity;
import com.project.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "bookingService")
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void saveOrder(FrontOrderEntity frontOrderEntity) {
        orderDao.save(frontOrderEntity);
    }
}
