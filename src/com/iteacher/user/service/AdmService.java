package com.iteacher.user.service;

import java.util.List;

import com.iteacher.user.model.Admin;

public interface AdmService {
	List<Admin> getAdminList(int page, int rows);
	int getAllAdminCount();
}
