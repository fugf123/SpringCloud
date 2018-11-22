package com.imooc.boot.config;

import com.imooc.boot.domain.User;
import com.imooc.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Collection;


/**
 * 路由器函数配置
 */
@Configuration
public class RouteFunctionConfiguration {
/**
 * 在响应式编程中，请求和响应不再是HttpServletRequest和HttpServletResponse，而是变成了ServerRequest和ServerResponse
 * @param request 请求
 * @param response 响应
 * @return Mono和Flux主要用于响应式编程的“异步”数据流处理，不像我们以前直接返回String/List<T>....，而是直接包装成
 *         Mono和Flux对象。见文知意，Mono主要用于返回单个数据，Flux用于返回多个数据。比如我们要根据id查询某个User，
 *         那返回的肯定就是一个User，那么需要包装成Mono<User>；若我们需要获取所有User，这是一个集合，我们需要包装成
 *         Flux<User>。这里的单个数据并不是指一个数据，而是指封装好的一个对象；多个数据就是多个对象
 *         ServerRequest request, ServerResponse response
 */
    /**
     *
     * @param userRepository
     * @return
     */
    @Bean
    @Autowired //参数注入
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        RouterFunction<ServerResponse> responseRouterFunction =
                RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                        request->{
                            Collection<User> userCollection = userRepository.findAll();
                            Flux<User> userFlux = Flux.fromIterable(userCollection);
                            return ServerResponse.ok().body(userFlux, User.class);
                        }).andRoute(RequestPredicates.POST("/person/save"),
                        request->{
                            User user = new User();
                            boolean success = userRepository.save(user);
                            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just(success),Boolean.class);
                        });
        return responseRouterFunction;
    }

}
