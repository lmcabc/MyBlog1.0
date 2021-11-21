package com.lmc.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器配置
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义的拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")//添加过滤路径
                .excludePathPatterns("/admin")//排除路径
                .excludePathPatterns("/admin/login");
    }
}
