package com.project.dao;

import com.project.entity.FrontcomplaintEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

public interface ComplaintDao  extends CrudRepository<FrontcomplaintEntity,Integer> {

    @Query(value = "SELECT \n" +
            "tc.fk_front_order_id as complaintId,\n" +
            "tc.f_complaint_contant as contant,\n" +
            "tc.f_complaint_time  as  complainttime,\n" +
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
            " from t_frontcomplaint as tc \n" +
            "LEFT JOIN t_front_order  as tor on tc.fk_front_order_id=tor.pk_id\n" +
            "LEFT JOIN t_front_user_info as tu1 on tor.fk_front_user_info_id=tu1.pk_id\n" +
            " LEFT JOIN t_front_deal as td on tor.fk_frontdeal_id=td.pk_id \n" +
            "LEFT JOIN t_front_stall as ts ON td.fk_front_stall_id=ts.pk_id\n" +
            "LEFT JOIN t_front_user_info as tu on ts.fk_front_user_id =tu.pk_id",nativeQuery = true)
    public List<Map> getAllComplaint();

@Modifying
@Transactional
@Query(value = "UPDATE t_frontcomplaint set f_complaint_state= :state WHERE pk_id = :id",nativeQuery = true)
    public void updateById( @Param("id") int id , @Param("state") int state);

@Query(value = "SELECT count(*)as countNum \n" +
        " from t_frontcomplaint as tc \n" +
        "LEFT JOIN t_front_order  as tor on tc.fk_front_order_id=tor.pk_id\n" +
        "LEFT JOIN t_front_user_info as tu1 on tor.fk_front_user_info_id=tu1.pk_id\n" +
        " LEFT JOIN t_front_deal as td on tor.fk_frontdeal_id=td.pk_id \n" +
        "LEFT JOIN t_front_stall as ts ON td.fk_front_stall_id=ts.pk_id\n" +
        "LEFT JOIN t_front_user_info as tu on ts.fk_front_user_id =tu.pk_id where td.pk_id=?1 ",nativeQuery = true)
public int getComplaintNum(int id);
}
