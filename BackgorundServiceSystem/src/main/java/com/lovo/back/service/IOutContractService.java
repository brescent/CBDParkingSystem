package com.lovo.back.service;

import com.lovo.back.entity.OutContractEntity;

import java.util.List;
import java.util.Optional;

public interface IOutContractService  {

/*查询所有的外部合约*/
    public List<OutContractEntity> findAll();

/*添加外部合约U*/
    public  void add(OutContractEntity  outContractEntity);
/*根据id来解除合约  修改合约生效状态*/
    public void updateState(int id);

    /*根据id查询合约详情*/

    public Optional<OutContractEntity> findById(int  id);

}
