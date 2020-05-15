package com.project.dao;

import com.project.entity.CompanyUserEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * 企业用户持久接口
 */
public interface ICompanyDao extends CrudRepository<CompanyUserEntity, Integer> {
    /**
     * 根据id修改企业用户详情
     *
     * @param contact
     * @param contactPhone
     */
    @Query("update CompanyUserEntity set contact=:contact,contactPhone=:contactPhone where id=:userId")
    public void updateCompanyUser(@Param("contact") String contact, @Param("contactPhone") String contactPhone, @Param("userId") int userID);


    /**
     * 根据用户id查询对应的企业用户详情
     *
     * @param userId
     * @return 企业实体
     */
    @Query("from CompanyUserEntity where publicUser.id=:userId")
    public CompanyUserEntity getCompanyUserById(@Param("userId") int userId);

    /**
     * 动态分页查询所有企业
     *
     * @param companyName    企业名称
     * @param companyAddress 企业地址
     * @param contact        联系人
     * @param contactPhone   联系人电话
     * @param pageable       分页对象
     * @return 分页对象
     */
    @Query(value=" select * from t_company where 1=1 " +
                    " and (c_company_name LIKE CONCAT('%',?1,'%') or ?1 is null)" +
                    " and (c_company_address LIKE CONCAT('%',?2,'%') or ?2 is null)"+
                    " and (c_contact LIKE CONCAT('%',?3,'%') or ?3 is null)" +
                    " and (c_contact_phone LIKE CONCAT('%',?4,'%') or ?4 is null)" +
                    " order by ?#{#pageable}"
            ,
            nativeQuery = true)
    public List<CompanyUserEntity> findAllCompany(String companyName, String companyAddress,
                                                  String contact, String contactPhone, PageRequest pageable);
    @Query(value="select count (*) from  t_company where 1=1 " +
            " and (c_company_name LIKE CONCAT('%',?1,'%') or ?1 is null)" +
            " and (c_company_address LIKE CONCAT('%',?2,'%') or ?2 is null)"+
            " and (c_contact LIKE CONCAT('%',?3,'%') or ?3 is null)" +
            " and (c_contact_phone LIKE CONCAT('%',?4,'%') or ?4 is null)"
            ,
            nativeQuery = true)
    public List<BigInteger> findAllCount(String companyName, String companyAddress,
                                         String contact, String contactPhone);
}
