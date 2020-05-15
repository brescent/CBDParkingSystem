package com.lovo.back.service;

import com.lovo.back.entity.OutContractEntity;
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
    public  void add(OutContractEntity  outContractEntity,int [] stallIdList);




/*根据id来解除合约  修改合约生效状态*/
    public void updateState(int id);

    /*根据id查询合约详情*/

    public OutContractEntity findById(int  id);

}
