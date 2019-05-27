package com.hujing.springcloudalibabagateway.fitler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author hj
 * @create 2019-05-27 23:50
 * 自定义全局过滤器
 */
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        ServerHttpResponse response = exchange.getResponse();
        if (token == null || token.isEmpty()) {
            //返回错误信息
            Map<String, String> body = Maps.newHashMap();
            body.put("msg", "必须携带token");
            body.put("state", "500");
            try {
                byte[] records = objectMapper.writeValueAsBytes(body);
                DataBuffer buffer = response.bufferFactory().wrap(records);
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
                return response.writeWith(Mono.just(buffer));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
