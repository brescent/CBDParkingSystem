package com.lovo.back.service;

import com.lovo.back.entity.CompanyContractEntity;
import com.lovo.back.entity.PaginationBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ICompanyContractService {

/*查询所有的租户合约*/
    public List<CompanyContractEntity> findAll();


    /*添加租户合约*/
    /*添加合约的时候根据 用户输入的企业名称 从公共服务器中得到企业对像 的id  在封装到合同对象中*/
    public  void add(CompanyContractEntity companyContractEntity,List<Integer> stallIdList);
/*根据id来解除合约  修改合约生效状态*/
    public void updateState(int id);




    /*根据id查询合约详情*/
    /*根据封装到租户合约中的企业对象外键  从公共服务器得到企业对像 */
    public CompanyContractEntity findById(int id);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PaginationBean<CompanyContractEntity>  findByPage(int currentPage,int pageSize);

}
