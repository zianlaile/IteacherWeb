package com.iteacher.user.dao;

import java.util.List;

import com.iteacher.user.model.Admin;
import com.iteacher.user.model.Session;

public interface UserMapper {
	Session findSessionBySessionid(String sid);
	List<Session> findSessionList(int offset, int limit);
	int countAllSession();
	Admin findAdminByNameAndPsd(String username, String password);
	
	
}
