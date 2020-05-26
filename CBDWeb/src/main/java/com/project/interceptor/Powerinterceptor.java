package com.project.interceptor;

import com.project.dto.PowerDto;
import com.project.dto.UserDto;
import com.project.entity.PowerEntity;

import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class Powerinterceptor implements HandlerInterceptor {


    @Autowired
    IUserService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDto userDto= (UserDto) request.getSession().getAttribute("user");
//        if(userDto!=null){
//            String userType=userDto.getUserType();
//            if(userType=="个人用户"){
//                String url = request.getRequestURI();
//                System.out.println(url);
//            }
//        }
        String url = request.getRequestURI();
        if(url.contains(".html")){
            String gerUrl=url.substring(10);
           if(userDto!=null){
               String userType=userDto.getUserType();
               if(userType.equals("个人用户")){
                    if(!gerUrl.contains("updatePersonalUser")&&!gerUrl.contains("checkMsgInfo")&&!gerUrl.contains("showAllPart")&&!gerUrl.contains("record")
                            &&!gerUrl.contains("complaint")&&!gerUrl.contains("For_sale")&&!gerUrl.contains("Purchase_res")&&!gerUrl.contains("Sell")
                    &&!gerUrl.contains("Buy")&&!gerUrl.contains("index")&&!gerUrl.contains("hireinfo")&&!gerUrl.contains("rent")
                    &&!gerUrl.contains("hire")&&!gerUrl.contains("lease")){

                            response.sendRedirect("/yzh/page/login.html");
                    }
               }
               else if(userType.equals("企业用户")){
                   if(!gerUrl.contains("updateCompanyUser")&&!gerUrl.contains("hireinfo")&&!gerUrl.contains("addStall")
                   &&!gerUrl.contains("index")){
                       response.sendRedirect("/yzh/page/login.html");
                   }

               }
               else if(userType.equals("超级管理员")){
                   if(!url.contains("xd")&&!url.contains("why")&&!gerUrl.contains("log")){
                       response.sendRedirect("/yzh/page/login.html");
                   }
               }
               else if(userType.equals("管理员")){
                   for (PowerDto power : userDto.getPowerList()) {
                       if(power.getPowerName().equals("用户管理")){

                           if(!gerUrl.contains("addCompany")&&!gerUrl.contains("showAllCompany")&&
                           !gerUrl.contains("checkMsgInfo")&&!gerUrl.contains("showAllPart")&&
                           !gerUrl.contains("partInfo")&&!gerUrl.contains("log")&&!gerUrl.contains("checkAllMsg")){
                               response.sendRedirect("/yzh/page/login.html");
                           }
                       }
                       if(power.getPowerName().equals("投诉管理")){
                           if(!gerUrl.contains("showAllCompliant")&&!gerUrl.contains("CompliantInfo")&&!gerUrl.contains("log")){
                               response.sendRedirect("/yzh/page/login.html");
                           }
                       }
                       if(power.getPowerName().equals("车位管理") ){
                           if(!gerUrl.contains("showAllStall")&&!gerUrl.contains("addStall")&&!gerUrl.contains("log")){
                               response.sendRedirect("/yzh/page/login.html");
                           }
                       }
                       if(power.getPowerName().equals("合同管理") ){
                           if(!gerUrl.contains("addOutContract")&&!gerUrl.contains("showAllOutContract")&&
                           !gerUrl.contains("addCompanyContract")&&!gerUrl.contains("showAllCompanyContract")
                           &&!gerUrl.contains("goOnOutContract")&&!gerUrl.contains("goOnCompanyContract")
                           &&!gerUrl.contains("outContractInfo")&&!gerUrl.contains("companyContractInfo")
                                   &&!gerUrl.contains("log")){
                               response.sendRedirect("/yzh/page/login.html");
                           }

                       }
                   }
               }
           }

        }


        return  true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
