package com.imooc.order.controller;


import com.imooc.order.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/***
 * RefreshScope 刷新配置  哪个地方用到就在哪个地方刷新
 */
@RestController
@RefreshScope
public class OrderController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/msg")
    public String msg() {
        return "this is product' msg";
    }

    @GetMapping("/create")
    public String create() {
        //d第一种方式RestRemplate 写死url
        /*RestTemplate restTemplate = new RestTemplate();
        String url =  restTemplate.getForObject("http://localhost:8081/msg",String.class);
        System.out.println(url);*/

        //第二种方式 利用LoadBalancerClient获得url
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url1 = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
        RestTemplate restTemplate = new RestTemplate();
        String url =  restTemplate.getForObject(url1,String.class);
        //第三种方式
       /* String url = restTemplate.getForObject("http://PRODUCT/msg",String.class);*/
        System.out.println(url);
       //LoadBalancerClient ribbon负载均衡
        //1.服务发现 2.服务选择规则  3. 服务监听   ServerList IRule  ServerListFilter
        //主要流程 1.首先通过ServerList 获得所有的可用服务列表 2.然后通过ServerListFilter过滤掉一部分地址
        // 3.通过IRule选择一个实例作为最终的服务

        //真正是使用的DynamicServerListLoadBalancer负载均衡规则
        //第四种
        String msg = productClient.productMsg();

        return url;
    }
}
