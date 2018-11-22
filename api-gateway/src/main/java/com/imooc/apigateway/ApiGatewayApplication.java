package com.imooc.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	/***
	 *功能:动态读取配置路由
	 * 和ZuulProperties 类型
	 * 可以使用启动类替代
	 */
	@ConfigurationProperties("zuul")
	@RefreshScope
	public ZuulProperties zuulProperties() {
		return new ZuulProperties();
	}
}
