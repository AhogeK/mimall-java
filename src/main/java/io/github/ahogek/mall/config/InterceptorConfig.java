package io.github.ahogek.mall.config;

import io.github.ahogek.mall.interceptor.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private InterceptorPatternsConfig interceptorPatternsConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns(interceptorPatternsConfig.getPathPatterns())
               .excludePathPatterns(interceptorPatternsConfig.getExcludePathPatterns());
    }
}
