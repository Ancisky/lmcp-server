package com.kglab.lmcp.SpringConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO MVC请求设置
 * @author sc
 * @date 2021/1/14
 */

@Configuration
public class CrossConfig implements WebMvcConfigurer {
    /**
     * TODO 允许跨域
     * @param registry
     * @return void
     * @author sc
     * @date 2021/1/14
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET","HEAD","POST")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}