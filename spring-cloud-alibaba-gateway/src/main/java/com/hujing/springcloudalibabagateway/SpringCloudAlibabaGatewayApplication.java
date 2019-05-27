package com.hujing.springcloudalibabagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaGatewayApplication.class, args);
    }
}
