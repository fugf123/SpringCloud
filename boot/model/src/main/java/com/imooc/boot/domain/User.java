package com.imooc.boot.domain;

import lombok.Data;

/**
 * 用户模型
 */
@Data
public class User {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
