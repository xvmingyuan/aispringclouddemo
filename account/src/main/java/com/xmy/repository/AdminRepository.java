package com.xmy.repository;


import com.xmy.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
