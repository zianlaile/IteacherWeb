package com.iteacher.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iteacher.user.dao.AdmMapper;
import com.iteacher.user.model.Admin;
@Service
public class AdmServiceImpl implements AdmService {
	@Resource
	private AdmMapper admMapper;
	
	@Override
	public List<Admin> getAdminList(int page, int rows) {
		return admMapper.findAdminList((page - 1)*rows, rows);
	}

	@Override
	public int getAllAdminCount() {
		return admMapper.countAllAdmin();
	}

}
