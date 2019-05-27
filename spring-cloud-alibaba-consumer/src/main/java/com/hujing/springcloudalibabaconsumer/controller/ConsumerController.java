package com.hujing.springcloudalibabaconsumer.controller;

import com.hujing.springcloudalibabaconsumer.feign.ProviderFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hj
 * @create 2019-05-26 23:25
 */
@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("/consum")
    public String consum() {
//        log.info("【into consumer api ...】");
//        return restTemplate.getForObject("http://alibaba-provider/hi/{1}", String.class, "hujing");
        return providerFeign.sayHi("hujing");
    }
}
