package com.secbro2.config;

import com.secbro2.filter.ArgumentFilter;
import com.secbro2.filter.ArgumentParamFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * @author sec
 * @version 1.0
 * @date 2020/12/18
 **/
@Configuration
public class FilterConfig {

    @Resource
    private ArgumentFilter argumentFilter;

    @Resource
    private ArgumentParamFilter argumentParamFilter;

    @Bean
    public FilterRegistrationBean<Filter> registerAuthFilter() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(argumentFilter);
        registration.addUrlPatterns("/level2");
        registration.setName("authFilter");
        // 值越小，Filter越靠前
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<Filter> registerAuthFilter2() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(argumentParamFilter);
        registration.addUrlPatterns("/level3","/level4");
        // 注意不要重复
        registration.setName("authFilter2");
        // 值越小，Filter越靠前
        registration.setOrder(1);
        return registration;
    }

}
