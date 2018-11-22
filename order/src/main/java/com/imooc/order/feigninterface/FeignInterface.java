package com.imooc.order.feigninterface;

import com.imooc.order.config.FeignConfiguration;
import com.imooc.order.dataobject.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 采用feign自带的注解
 */
@FeignClient(name="provider",configuration = FeignConfiguration.class)
public interface FeignInterface {
    @GetMapping("/{id}")
    public ProductInfo findById(@PathVariable("id") int id);
}
