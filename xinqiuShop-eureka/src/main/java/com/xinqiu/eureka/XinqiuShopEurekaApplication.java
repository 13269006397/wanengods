package com.xinqiu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class XinqiuShopEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinqiuShopEurekaApplication.class, args);
        System.out.println("eureka模块启动");
    }

}
