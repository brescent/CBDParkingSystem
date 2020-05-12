package com.project.Service;


import com.project.entity.PersonalUserEntity;
import com.project.entity.PublicUserEntity;

/**用户业务层接口*/
public interface IUserService {
    /**
     * 用户登录,并且根据用户类型查询该用户的详细信息
     * @param userName
     * @param pwd
     *
     */
    public void login(String userName,String pwd);

    /**
     * 用户修改
     * @param email
     * @param jobInfo
     * @param phone
     * @param homeAddress
     * @param userName
     * @param pwd
     * @param userId
     */
    public void updatePersonalUser(String email,String jobInfo,String phone,String homeAddress,String userName,String pwd,int userId);

    /**
     *添加用户
     * @param publicUser
     * @param personalUser
     */
    public void addUser(PublicUserEntity publicUser, PersonalUserEntity personalUser);


    public Object getUserInfo(int userType,int userId);
}
