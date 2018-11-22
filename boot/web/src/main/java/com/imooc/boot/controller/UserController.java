package com.imooc.boot.controller;

import com.imooc.boot.domain.User;
import com.imooc.boot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@Slf4j
public class UserController {

    // @Autowired
    // private UserRepository userRepository;  字段注入

    /**
     * 构造器注入 优点:不能修改，提早初始化。通过传参传递
     */
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/saveUser")
    public User save(@RequestParam String name){

        User user = new User();
        user.setName(name);

        if(userRepository.save(user)){
            log.info("用户对象{}保存成功",user);
        }
        return user;
    }
}