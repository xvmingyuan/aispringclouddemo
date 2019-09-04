package com.xmy.repository;


import com.xmy.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
