package com.xmy.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    public long id;
    public User user;
    public Menu menu;
    public Admin admin;
    public Date date;
    public int state;
    public long aid;
}
