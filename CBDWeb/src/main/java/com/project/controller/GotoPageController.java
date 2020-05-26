package com.project.controller;

import com.project.util.RandomValidateCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GotoPageController {

    @RequestMapping("CBDLogin")
    public String gotoLogin(){

        return "yzh/page/login";
    }



}
