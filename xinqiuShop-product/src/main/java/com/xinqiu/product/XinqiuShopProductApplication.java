package com.xinqiu.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class XinqiuShopProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(XinqiuShopProductApplication.class, args);
    }

}
