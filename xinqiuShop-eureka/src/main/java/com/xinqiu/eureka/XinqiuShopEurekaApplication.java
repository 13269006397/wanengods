package com.xinqiu.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class XinqiuShopEurekaApplication {
    private static final Logger log = LoggerFactory.getLogger(XinqiuShopEurekaApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(XinqiuShopEurekaApplication.class, args);
        log.info("eureka模块启动");
    }

}
