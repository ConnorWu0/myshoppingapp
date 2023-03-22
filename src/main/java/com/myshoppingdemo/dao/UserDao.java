package com.myshoppingdemo.dao;

import com.myshoppingdemo.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
}
