package com.project.dao;

import com.project.entity.FrontDealEntity;
import com.project.entity.FrontStallEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface DealDao extends CrudRepository<FrontDealEntity ,Integer> {


    @Query(value = "SELECT td.f_deal_end_date as dealEndDate,\n" +
            "            td.f_deal_price as dealPrice,\n" +
            "            td.f_deal_start_date as dealStateDate,\n" +
            "            td.f_deal_state as dealState,\n" +
            "            td.f_deal_type as dealType,\n" +
            "            td.pk_id as pk_id,\n" +
            "            ts.fk_front_user_id as userId,\n" +
            "            ts.f_stall_address as stallAddress,\n" +
            "            ts.pk_id as stallId,\n" +
            "            tu.f_user_name as userName,\n" +
            "            tu.f_user_profession as userProfession\n" +
            "              from t_front_deal AS td LEFT JOIN t_front_stall as ts\n" +
            "             ON td.fk_front_stall_id=ts.pk_id  LEFT JOIN t_front_user_info as tu\n" +
            "            on ts.fk_front_user_id=tu.pk_id\n" +
            "             WHERE td.f_deal_state=0",nativeQuery = true)
    public  List<Map> getAllDeal();


@Query(value = "UPDATE t_front_deal set f_deal_state= :state WHERE pk_id = :id",nativeQuery = true)
    public void updateDealById(@Param("id") int id , @Param("state") int state);

@Query(value = "SELECT td.f_deal_end_date as dealEndDate,\n" +
        "            td.f_deal_price as dealPrice,\n" +
        "            td.f_deal_start_date as dealStateDate,\n" +
        "            td.f_deal_end_date as dealEndDate,\n" +
        "            td.f_deal_state as dealState,\n" +
        "            td.f_deal_type as dealType,\n" +
        "            td.pk_id as pk_id,\n" +
        "            ts.fk_front_user_id as userId,\n" +
        "            ts.f_stall_address as stallAddress,\n" +
        "            ts.pk_id as stallId,\n" +
        "            tu.f_user_name as userName,\n" +
        "            tu.f_user_profession as userProfession\n" +
        "              from t_front_deal AS td LEFT JOIN t_front_stall as ts\n" +
        "             ON td.fk_front_stall_id=ts.pk_id  LEFT JOIN t_front_user_info as tu\n" +
        "            on ts.fk_front_user_id=tu.pk_id\n" +
        "             WHERE td.pk_id=?1",nativeQuery = true)
public List<Map> getDealById(int id);
}
