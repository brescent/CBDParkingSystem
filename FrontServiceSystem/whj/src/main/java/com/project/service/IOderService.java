package com.project.service;


import java.util.List;
import java.util.Map;

public interface IOderService {

    String  saveOrder(String message, int id);

    List<Map> findOrderByDealId(int id);

}
