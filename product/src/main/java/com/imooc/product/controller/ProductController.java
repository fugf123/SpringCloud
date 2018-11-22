package com.imooc.product.controller;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.IProductService;
import com.imooc.product.vo.ResultVo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/8/9.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService _productService;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(value = "/list")
    public ResultVo<ProductInfo> findUpAll(){
        List<ProductInfo> list = this._productService.findUpAll();
        System.out.println(list.stream().count());
        //发送消息
        amqpTemplate.convertAndSend("productInfo","product");//注意:需要在消息接收端 rabbitListener 接收消息 创建队列
        return ResultVo.success(list);
    }
}
