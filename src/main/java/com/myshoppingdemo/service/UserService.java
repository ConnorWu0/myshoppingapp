package com.myshoppingdemo.service;

import com.myshoppingdemo.entity.User;
import com.myshoppingdemo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);

	void deleteById(Long theId);

}
