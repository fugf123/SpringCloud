package com.imooc.product.feigninterface;

import com.imooc.product.dataobject.ProductInfo;

public interface ProductInfoFeignClient {

    ProductInfo findByID(int id);
}
