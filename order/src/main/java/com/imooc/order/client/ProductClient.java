package com.imooc.order.client;

import com.imooc.order.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "product",configuration = FeignConfiguration.class)
@Component
public interface ProductClient {
    @GetMapping("msg")
    String productMsg();
}
