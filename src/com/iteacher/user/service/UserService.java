package com.iteacher.user.service;

import java.util.List;

import com.iteacher.user.model.Session;
import com.iteacher.util.pNews;

public interface UserService {
	Session getSessionBySid(String sid);
	List<Session> getSessionList(int page, int rows);
	int getAllSessionCount();
	boolean checkAdmin(String username, String password);
	List<Session> getSessionList(pNews news);
	

}
