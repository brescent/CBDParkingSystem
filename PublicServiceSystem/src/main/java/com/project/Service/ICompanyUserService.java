package com.project.Service;

import com.project.vo.CompanyVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 企业用户业务接口
 */
public interface ICompanyUserService {
    /**
     * 添加新企业
     * @param company 企业实体     */
    public String addCompany(CompanyVo company);


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
    public String getAllCompany(
            String companyName,String companyAddress,
            String contact,String contactPhone ,
            int pageNum,int pageSize);

    /**
     * 根据id删除公司
     * @param companyId 公司id
     */
    public String delCompany(int companyId);




    /**
     * 根据id查询企业
     * @param companyId
     * @return
     */
    public String getCompanyById(int companyId);

    /**
     * 根据用户id查询对应的企业详细信息
     * @param userId 用户id
     * @return 企业实体
     */
    public String getCompanyUserById(int userId);

    /**
     * 修改企业用户信息
     * @param map 新数据
     * @return
     */
    @RequestMapping("/updCompany")
    public  String updCompany(@RequestBody Map<String,Object> map);
}
