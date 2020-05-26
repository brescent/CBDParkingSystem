package com.project.dao;

import com.project.entity.FrontOrderEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface OrderDao extends CrudRepository<FrontOrderEntity,Integer> {


    @Query(value = "SELECT *from  t_front_order as t WHERE  t.fk_front_user_info_id=?1",nativeQuery = true)
    public List<FrontOrderEntity> orderByUserid(int id);

    @Query(value = "SELECT \n" +
            "tor.Pk_id as orerId,\n" +
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
            " from t_front_order  as tor \n" +
            "LEFT JOIN t_front_user_info as tu1 on tor.fk_front_user_info_id=tu1.pk_id\n" +
            " LEFT JOIN t_front_deal as td on tor.fk_frontdeal_id=td.pk_id \n" +
            "LEFT JOIN t_front_stall as ts ON td.fk_front_stall_id=ts.pk_id\n" +
            "LEFT JOIN t_front_user_info as tu on ts.fk_front_user_id =tu.pk_id where tu1.pk_id=?1",nativeQuery = true)
    public List<Map> getAllOrderByUserId(int id);

@Query(value = "SELECT \n" +
        "tor.Pk_id as orerId,\n" +
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
        " from t_front_order  as tor \n" +
        "LEFT JOIN t_front_user_info as tu1 on tor.fk_front_user_info_id=tu1.pk_id\n" +
        " LEFT JOIN t_front_deal as td on tor.fk_frontdeal_id=td.pk_id \n" +
        "LEFT JOIN t_front_stall as ts ON td.fk_front_stall_id=ts.pk_id\n" +
        "LEFT JOIN t_front_user_info as tu on ts.fk_front_user_id =tu.pk_id where tor.pk_id=?1",nativeQuery = true)
    public List<Map> getOrderById(int id);

}
