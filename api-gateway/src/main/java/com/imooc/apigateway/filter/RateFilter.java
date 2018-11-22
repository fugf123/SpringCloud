package com.imooc.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.imooc.apigateway.exception.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * 定义限流器
 */
public class RateFilter extends ZuulFilter {

    private static  final RateLimiter RATE_LIMITER = RateLimiter.create(100);//创建令牌桶
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        if(!RATE_LIMITER.tryAcquire()){
           throw new RateLimitException();
        }
        return null;
    }
}
