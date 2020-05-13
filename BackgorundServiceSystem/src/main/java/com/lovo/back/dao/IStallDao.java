package com.lovo.back.dao;

import com.lovo.back.entity.StallEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository(value = "stallDao")
public interface IStallDao  extends JpaRepository<StallEntity,Integer> {


    /*企业用户查询平台空闲的车位*/
    @Query(value = "select * from  t_stall where peopleNo is null and state =0",nativeQuery = true)
    public List<StallEntity>  findByState();


    /*跟据 车位地址和编号进行动态查询*/
    @Query(value="select * from  t_stall " +
            "where (stallAddress=?1 or ?1 is null)" +
            "where (stallNo=?1 or ?1 is null)" +
            "order by ?#{#pageable}",
          countQuery = " select count(*) from t_stall" +
                  "where (stallAddress=?1 or ?1 is null)" +
                  "where (stallNo=?1 or ?1 is null)" +
                  "order by ?#{#pageable}",nativeQuery = true)
    public List<StallEntity>  findByItems(String stallAddress, String stallNo,  Pageable pageable);



    /*批量添加*/


    /*修改车位的所属者身份证号*/
    @Modifying
    @Query(value=" update t_stall set peopleNo=?1 where pk_id=?2",nativeQuery=true)
    public void updatePeopleNo(int id,String peopleNum);




}
