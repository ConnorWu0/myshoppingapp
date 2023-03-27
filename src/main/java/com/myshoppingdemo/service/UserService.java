package com.myshoppingdemo.service;

import com.myshoppingdemo.entity.User;
import com.myshoppingdemo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

	public Optional<User> findByUserName(String userName);

	public void save(CrmUser crmUser);

	void deleteById(Long theId);

}
