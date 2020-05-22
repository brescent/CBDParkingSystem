package com.project.dao;

import com.project.entity.FrontDealEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DealDao extends CrudRepository<FrontDealEntity,Integer> {


    @Query(value = "SELECT * FROM t_front_deal",nativeQuery = true)
    List<FrontDealEntity> getAllByDealEndDate();

    @Query(value = "SELECT user.pk_id as userId,deal.pk_id as dealId,stall.f_stall_address as stallAddress,stall.f_idnum as idnum,deal.f_deal_price as dealPrice,\n" +
            " user.f_user_profession as profession,user.f_real_name as realName,user.f_user_name as userName,stall.f_stall_num as stallNum\n" +
            "            from t_front_deal as deal LEFT JOIN t_front_stall as stall on deal.fk_front_stall_id\n" +
            "            =stall.pk_id LEFT JOIN t_front_user_info as user on stall.fk_user_id = user.pk_id WHERE deal.pk_id =?1",nativeQuery = true)
    List<Object[]> getDealById(int id);


    @Query(value = "SELECT * FROM t_front_deal where t_front_deal.pk_id=?1",nativeQuery = true)
    FrontDealEntity getDealById2(int id);
}
