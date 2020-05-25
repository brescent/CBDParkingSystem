package com.project.dao;


import com.project.entity.FrontPactEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface PactDao extends CrudRepository<FrontPactEntity,Integer> {

@Query(value = "SELECT \n" +
        "tp.pk_id as pactId,\n" +
        "tp.f_pact_state as pactstate,\n" +
        "td.f_deal_price as dealPrice,\n" +
        "             td.f_deal_start_date as dealStateDate,\n" +
        "             td.f_deal_state as dealState,\n" +
        "             td.f_deal_type as dealType,\n" +
        "             td.pk_id as pk_id,\n" +
        "            ts.fk_front_user_id as userId,\n" +
        "             ts.f_stall_address as stallAddress,\n" +
        "            ts.pk_id as stallId,\n" +
        "            tu.f_user_name as userName,\n" +
        "           tu.f_user_profession as userProfession,\n" +
        "                tu1.f_user_name as customerName,\n" +
        "           tu1.f_user_profession as customerProfession,\n" +
        "             tu1.pk_id as customerId\n" +
        " from t_front_pact as tp \n" +
        "LEFT JOIN t_front_order  as tor on tp.fk_front_order_id=tor.pk_id\n" +
        "LEFT JOIN t_front_user_info as tu1 on tor.fk_front_user_info_id=tu1.pk_id\n" +
        " LEFT JOIN t_front_deal as td on tor.fk_frontdeal_id=td.pk_id \n" +
        "LEFT JOIN t_front_stall as ts ON td.fk_front_stall_id=ts.pk_id\n" +
        "LEFT JOIN t_front_user_info as tu on ts.fk_front_user_id =tu.pk_id WHERE tp.f_pact_state=0",nativeQuery = true)
  public List<Map> getAllPact();
}
