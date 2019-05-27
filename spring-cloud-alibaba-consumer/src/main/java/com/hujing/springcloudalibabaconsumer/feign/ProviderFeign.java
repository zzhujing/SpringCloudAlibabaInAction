package com.hujing.springcloudalibabaconsumer.feign;

import com.hujing.springcloudalibabaconsumer.feign.fallback.ProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hj
 * @create 2019-05-26 23:35
 */
@FeignClient(value = "alibaba-provider",fallback = ProviderFallback.class)
public interface ProviderFeign {

    @GetMapping("/hi/{name}")
    String sayHi(@PathVariable String name);
}
