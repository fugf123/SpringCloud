package com.imooc.product.service;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.AssertTrue;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/8/9. //继承测试主类需要加Component
 */
@Component
public class IProductServiceTest extends ProductApplicationTests {

    @Autowired
    private IProductService _productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = _productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }

}