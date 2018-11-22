package com.imooc.order.feigninterface;

import com.imooc.order.dataobject.ProductInfo;

public class FeignClientFallback  implements UserFeignClient {
    @Override
    public ProductInfo findByID(int id) {
        ProductInfo user = new ProductInfo();
        user.setProductId("1");
        user.setProductDescription("请求失败！");
        return user;
    }
}