package com.myshoppingdemo.dao;

import com.myshoppingdemo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
