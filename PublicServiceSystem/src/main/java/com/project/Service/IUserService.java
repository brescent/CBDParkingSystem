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
    public PublicUserEntity login(String userName,String pwd);

    /**
     * 用户修改，可以修改用户邮箱，职业描述，电话号码，家庭住址，面膜
     * @param personalUserEntity
     * @param userId 用户id
     */
    public void updatePersonalUser( PersonalUserEntity personalUserEntity,int userId,PublicUserEntity publicUserEntity);

    /**
     *添加用户
     * @param publicUser
     * @param personalUser
     */
    public void addUser(PublicUserEntity publicUser, PersonalUserEntity personalUser);


    /**
     * 通过姓名查找用户，做到重名验证
     * @param userName
     * @return
     */
    public PublicUserEntity findUserByName(String userName);


    public PersonalUserEntity findByPublicUserId(int publicUserId);

}
