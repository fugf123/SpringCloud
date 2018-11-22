package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/9.
 */
@Component
public class ProductServiceImpl implements IProductService {
    @Override
    public List<ProductInfo> findUpAll(){
        List<ProductInfo> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setCategoryType(1);
            productInfo.setCreateTime(new Date());
            productInfo.setProductDescription("八宝粥");
            productInfo.setProductId(UUID.randomUUID().toString());
            list.add(productInfo);
        }
        return list;
    }
}
