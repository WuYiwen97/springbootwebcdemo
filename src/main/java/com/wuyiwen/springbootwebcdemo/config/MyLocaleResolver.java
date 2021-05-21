package com.wuyiwen.springbootwebcdemo.config;


import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//国际化
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求语言参数
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();

        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            Locale locale1 = new Locale(split[0], split[1]);
            return locale1;
        }
        return locale;

    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
