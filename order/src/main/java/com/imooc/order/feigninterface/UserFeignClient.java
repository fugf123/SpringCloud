package com.imooc.order.feigninterface;

import com.imooc.order.dataobject.ProductInfo;

public interface UserFeignClient {

    ProductInfo findByID(int id);
}
