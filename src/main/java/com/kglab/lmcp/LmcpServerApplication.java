package com.kglab.lmcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO 项目启动入口
 * @author sc
 * @date 2021/1/14
 */
@SpringBootApplication
public class LmcpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmcpServerApplication.class, args);
    }
}
