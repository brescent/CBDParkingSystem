package com.lovo.back.service;

import com.lovo.back.entity.OutContractEntity;
import com.lovo.back.entity.PaginationBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IOutContractService  {

/*查询所有的外部合约*/
    public List<OutContractEntity> findAll();

    /**
     * 添加外部合约
     * @param outContractEntity  外部合约对象
     * @param stallIdList 车位id集合
     */
    public  void add(OutContractEntity  outContractEntity,List<Integer> stallIdList);




/*根据id来解除合约  修改合约生效状态*/
    public void updateState(int id);

    /*根据id查询合约详情*/

    public OutContractEntity findById(int  id);

    /**
     * 分页查询
     * @param currentPage 当前页
     * @param pageSize 大小
     * @return
     */
    public PaginationBean<OutContractEntity> findByPage(int currentPage, int pageSize);

}
