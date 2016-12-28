package com.iteacher.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iteacher.user.dao.UserMapper;
import com.iteacher.user.model.Session;
import com.iteacher.util.pNews;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	
	
	
	@Override
	public Session getSessionBySid(String sid) {
		return userMapper.findSessionBySessionid(sid);
	}

	@Override
	public List<Session> getSessionList(int page, int rows) {
		return userMapper.findSessionList((page - 1)*rows, rows);
	}

	@Override
	public int getAllSessionCount() {
		return userMapper.countAllSession();
	}

	@Override
	public boolean checkAdmin(String username, String password) {
		if (userMapper.findAdminByNameAndPsd(username, password) == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Session> getSessionList(pNews news) {
		// TODO Auto-generated method stub
		return userMapper.findSessionList((news.getPage()-1)*news.getRows(),news.getRows());
	}



}
