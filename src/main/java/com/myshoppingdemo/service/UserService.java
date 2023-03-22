package com.myshoppingdemo.service;

import com.myshoppingdemo.entity.User;
import com.myshoppingdemo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
