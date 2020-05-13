package com.project.Service;

import com.project.entity.CompanyUserEntity;

import java.util.List;

/**
 * 企业用户业务接口
 */
public interface ICompanyUserService {
    /**
     * 添加新企业
     * @param company 企业实体
     */
    public void addCompany(CompanyUserEntity company);

    /**
     * 根据用户id查询对应的企业详细信息
     * @param userId 用户id
     * @return 企业实体
     */
    public CompanyUserEntity getCompanyUserById(int userId);

    /**
     * 查询所有企业
     * @return 企业实体集合
     */
    public List<CompanyUserEntity> getAllCompany();

    /**
     * 根据id删除公司
     * @param companyId 公司id
     */
    public void delCompany(int companyId);

    /**
     * 根据企业id修改企业联系人以及联系电话
     * @param contact 联系人
     * @param contactPhone 联系电话
     * @param companyId 企业id
     */
    public void updCompany(String contact,String contactPhone,int companyId);


}
