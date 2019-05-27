package com.hujing.springcloudalibabaconsumer.feign.fallback;

import com.hujing.springcloudalibabaconsumer.feign.ProviderFeign;
import org.springframework.stereotype.Component;

/**
 * @author hj
 * @create 2019-05-27 20:51
    熔断类
 */
@Component
public class ProviderFallback implements ProviderFeign {
    @Override
    public String sayHi(String name) {
        return "network busy.... please try after .";
    }
}
