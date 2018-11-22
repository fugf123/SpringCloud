package com.imooc.product.client;

import com.imooc.product.config.FeignConfiguration;
import com.imooc.product.feigninterface.FeignClientFallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "product",configuration = FeignConfiguration.class,fallback = FeignClientFallback.class)
@Component
public interface ProductClient {
    @GetMapping("msg")
    String productMsg();
}
