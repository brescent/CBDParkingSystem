package com.project.util;

import com.project.Service.IUserService;
import com.project.Service.impl.UserServiceImpl;
import com.project.entity.PersonalUserEntity;
import com.project.entity.PublicUserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MD5Test {

        @Autowired
        private  IUserService service;


        public static void main(String[] args){
//            String userName = "zyg";
//            String password = "123";
//            registerUser(userName,password);

          String   userName = "Will";
          String   password = "456";
          String realName="小明";
          String email="1111@qq.com";
          String homeAddress="人民南路130号";
          String phone="13900763345";
          String jobInfo="java菜鸟开发人员";
          String IDCardNum="511132300106274343242";
           //registerUser(userName,password,realName, email, homeAddress, phone, jobInfo, IDCardNum);

            String loginUserId = "Will";
            String pwd = "456";
//            try {
//                if(loginValid(loginUserId,pwd)){
//                    System.out.println("欢迎登陆！！！");
//                }else{
//                    System.out.println("口令错误，请重新输入！！！");
//                }
//            } catch (NoSuchAlgorithmException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (UnsupportedEncodingException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        }

        /**
         * 注册用户
         *
         * @param userName
         * @param pwd
         */
        public    void registerUser(String userName,String pwd,String realName,String email,String homeAddress,String phone,String jobInfo,String IDCardNum){
            String encryptedPwd = null;
            try {
                encryptedPwd = MD5Util.getEncryptedPwd(pwd);
                PublicUserEntity mainUser=new PublicUserEntity(userName,encryptedPwd,0);
                PersonalUserEntity user=new PersonalUserEntity(realName,email,homeAddress,phone,jobInfo,IDCardNum);
                service.addUser(mainUser,user);

            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        /**
         * 验证登陆
         *
         * @param userName
         * @param password
         * @return
         * @throws UnsupportedEncodingException
         * @throws NoSuchAlgorithmException
         */
        public  boolean loginValid(String userName,String password)
                throws NoSuchAlgorithmException, UnsupportedEncodingException{
             /*String loginUserId = "zyg";
               String pwd = "1232";*/
           // String pwdInDb = (String)users.get(userName);
          String   pwdInDb=service.findUserByName(userName).getLoginName();
            System.out.println(pwdInDb);
            if(null!=pwdInDb){ // 该用户存在
                return MD5Util.validPasswd(password, pwdInDb);
            }else{
                System.out.println("不存在该用户！！！");
                return false;
            }
        }
    }

