package com.lovo.back.service;

import com.lovo.back.entity.CompanyContractEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ICompanyContractService {

/*查询所有的租户合约*/
    public List<CompanyContractEntity> findAll();

/*添加租户合约*/
    public  void add(CompanyContractEntity companyContractEntity,int [] stallIdList);
/*根据id来解除合约  修改合约生效状态*/
    public void updateState(int id);

    /*根据id查询合约详情*/

    public CompanyContractEntity findById(int id);

}
