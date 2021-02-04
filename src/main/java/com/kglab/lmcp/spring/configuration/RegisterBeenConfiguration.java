package com.kglab.lmcp.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * TODO  注册spring been$
 *
 * @author sc
 * @date 2021/2/4
 */
@Configuration
public class RegisterBeenConfiguration {


    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplateBuilder.build();
    }

}
