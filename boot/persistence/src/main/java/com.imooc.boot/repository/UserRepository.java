package com.imooc.boot.repository;

import com.imooc.boot.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 领域模型
 *
 */
@Repository
public class UserRepository {
    /**
     * 采用内存型存储方式 Map
     */
    private final ConcurrentHashMap<Integer,User> repository = new ConcurrentHashMap<>();
    /*
    *自增长
     */
    private final static AtomicInteger idGenerator = new AtomicInteger();
    /**n
     * 保存用户对象
     * @param user
     * @return 如果保存成功，返回<code>true</code>
     */
    public boolean save(User user){
        boolean success = false;
        //id从 开始
        Integer id = idGenerator.incrementAndGet();
        return repository.put(id,user) == null;//等于null说明保存成功
    }
    public Collection<User> findAll(){
        return repository.values();
    }




}
