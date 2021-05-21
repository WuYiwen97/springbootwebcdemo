package com.wuyiwen.springbootwebcdemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //无业务逻辑跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/main.html").setViewName("main");
    }


    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login", "/css/**", "/js/**", "/img/**");
    }
}
