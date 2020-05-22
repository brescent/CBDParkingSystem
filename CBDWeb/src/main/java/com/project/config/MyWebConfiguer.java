package com.project.config;


import com.project.interceptor.MyInterceptor;
import com.project.interceptor.Powerinterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MyWebConfiguer implements WebMvcConfigurer {


    /**
     * 放行静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
     //放行的文件
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");


    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
              .excludePathPatterns("/yzh/page/login.html","/yzh/page/addUser.html",
                     "/login","/addUser","/yzh/css/**","/yzh/js/**"
              );


       registry.addInterceptor(new Powerinterceptor()).addPathPatterns("/**")
       .excludePathPatterns("/yzh/css/**").excludePathPatterns("/yzh/js/**")
       .excludePathPatterns("/bwk/css/**").excludePathPatterns("/bwk/js/**")
       .excludePathPatterns("/font/css/**").excludePathPatterns("/font/js/**")
       .excludePathPatterns("/why/css/**").excludePathPatterns("/why/js/**")
       .excludePathPatterns("/xd/css/**").excludePathPatterns("/xd/js/**")
        .excludePathPatterns("/yzh/page/login.html").excludePathPatterns("/yzh/page/addUser.html")
        .excludePathPatterns("/yzh/page/main.html").excludePathPatterns("/bwk/page/billList.html")
         .excludePathPatterns("/bwk/page/showMessageList.html")
       .excludePathPatterns("/addUser").excludePathPatterns("/login").excludePathPatterns("/yzh/page/publicServiceMain.html");

    }


}
