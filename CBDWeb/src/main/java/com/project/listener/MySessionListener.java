package com.project.listener;


import com.project.util.OnlineUserCountUtil;

import javax.servlet.http.*;


public class MySessionListener implements HttpSessionListener {
    public int count=0;//记录session的数量
    @Override
    public void sessionCreated(HttpSessionEvent se) {

        //OnlineUserCountUtil.login();
        count++;
        se.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        count--;
        se.getSession().getServletContext().setAttribute("count", count);
    }
}

