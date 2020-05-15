package com.project.Service;

import com.project.entity.CompanyUserEntity;
import com.project.entity.PageEntity;
import org.omg.CORBA.INTERNAL;

import java.util.List;
import java.util.Optional;

/**
 * 企业用户业务接口
 */
public interface ICompanyUserService {
    /**
     * 添加新企业
     * @param company 企业实体
     * @param companyLoginName 企业登录名
     * @param companyLoginPwd 企业登录密码
     */
    public void addCompany(CompanyUserEntity company, String companyLoginName, String companyLoginPwd);

    /**
     * 根据用户id查询对应的企业详细信息
     * @param userId 用户id
     * @return 企业实体
     */
    public CompanyUserEntity getCompanyUserById(int userId);

    /**
     * 动态分页查询所有企业
     * @param companyName 企业名称
     * @param companyAddress 企业地址
     * @param contact 联系人
     * @param contactPhone 联系人电话
     * @param pageNum 当前页码
     * @param pageSize 每页显示条数
     * @return 分页对象
     */
    public PageEntity<CompanyUserEntity> getAllCompany(
            String companyName,String companyAddress,
            String contact,String contactPhone ,
            int pageNum,int pageSize);

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
    public void updCompany(String contact, String contactPhone, int companyId);


    /**
     * 根据id查询企业
     * @param companyId
     * @return
     */
    public CompanyUserEntity getCompanyById(int companyId);
}
