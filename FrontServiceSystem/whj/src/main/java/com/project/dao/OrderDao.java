package com.project.dao;

import com.project.entity.FrontOrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface OrderDao extends CrudRepository<FrontOrderEntity,Integer> {

    @Query(value = "SELECT userinfo.f_user_name as userName,userinfo.f_real_name as realName,\n" +
            "userinfo.f_idnum as idnum,userinfo.f_user_profession as profession,\n" +
            "deal.f_deal_price as price,forder.f_message as message\n" +
            "FROM t_front_order as forder \n" +
            "LEFT JOIN t_front_deal as deal on forder.fk_deal_id = deal.pk_id \n" +
            "LEFT JOIN t_front_user_info as userinfo\n" +
            "on forder.fk_front_user_info_id = userinfo.pk_id WHERE deal.pk_id =?1 ",nativeQuery = true)
    List<Map> findOrderByDealId(int id);
}
