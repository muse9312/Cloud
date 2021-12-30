package com.ggoreb.practice.config;

import com.ggoreb.practice.interceptor.SignInCheckInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private SignInCheckInterceptor signInCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInCheckInterceptor)
                .addPathPatterns("/question/create", "/question/detail/**", "/upload/**")
                .excludePathPatterns("/question/list");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
