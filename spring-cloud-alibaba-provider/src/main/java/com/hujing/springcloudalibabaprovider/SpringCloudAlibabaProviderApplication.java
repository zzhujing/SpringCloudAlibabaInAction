package com.hujing.springcloudalibabaprovider;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class SpringCloudAlibabaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaProviderApplication.class, args);
    }


    @GetMapping("/hi/{name}")
    public String sayHi(@PathVariable String name) {
        log.info("【into provider api ...】");
        return String.format("hi, %s ~", name);
    }
}
