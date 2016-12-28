package com.iteacher.user.dao;

import java.util.List;

import com.iteacher.user.model.Admin;

public interface AdmMapper {
	
	//用户信息列表查询
	List<Admin> findAdminList(int offset, int limit);
	int countAllAdmin();
	
	Admin findByname (String username);
	
}
