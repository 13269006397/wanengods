package com.xinqiu.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class XinqiuShopUserApplication {

    private static final Logger log = LoggerFactory.getLogger(XinqiuShopUserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(XinqiuShopUserApplication.class, args);
        log.info("user模块启动");
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
