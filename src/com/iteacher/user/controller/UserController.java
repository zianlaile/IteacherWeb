package com.iteacher.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.iteacher.user.model.Admin;
import com.iteacher.user.model.AdminPage;
import com.iteacher.user.model.Session;
//import com.iteacher.user.model.SessionPage;
import com.iteacher.user.service.AdmService;
import com.iteacher.user.service.UserService;
import com.iteacher.util.DataGrid;
import com.iteacher.util.Json;
import com.iteacher.util.pNews;


@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;
	
	@Resource
	private AdmService admService;
	

	
	/**
	 *
	 * @author : neog
	 * @time : 2016年4月15日
	 * @description : for testing，page rows由easyui自动传入，需要返回的内容格式固定total和一个list对象
	 */
/*	@RequestMapping(value = "/session/list")
	public @ResponseBody SessionPage getSessionList(int page, int rows) {
		SessionPage sp = new SessionPage();
		List<Session> list = userService.getSessionList(page, rows);
		sp.setRows(list);
		sp.setTotal(userService.getAllSessionCount());
		logger.info("/session/list--page:" + page + ",rows:" + rows);
		return sp;
	}*/
	
	@RequestMapping(value = "/session/list")
	public @ResponseBody DataGrid getSessionList(pNews news) {
		DataGrid dGrid = new DataGrid();
		List<Session> list = userService.getSessionList(news);
		dGrid.setRows(list);
		dGrid.setTotal((long) userService.getAllSessionCount());
		//logger.info("/session/list--page:" + page + ",rows:" + rows);
		return dGrid;
	}
	
	/***
	 *@author : zhou
	 * @time : 2016年4月22日
	 * @description 将用户信息显示在页面（学校信息）
	 */
	@RequestMapping("/admin/list")
	public @ResponseBody AdminPage getAdminList(int page, int rows){
		AdminPage aPage = new AdminPage();
		List<Admin> list = admService.getAdminList(page, rows);
		aPage.setRows(list);
		aPage.setTotal(admService.getAllAdminCount());
		logger.info("/admin/list--page:" + page + ",rows" + rows);
		return aPage;
	}
	
	
	
	/**
	 *
	 * @author : neog
	 * @time : 2016年4月16日
	 * @description : 登录用户名密码验证
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/checkLoginUser")
	public @ResponseBody Map ckLoginUser(HttpSession httpSession, @RequestParam String username, @RequestParam String password) {
		Map rMap = new HashMap();
		if (userService.checkAdmin(username, password)) {
			rMap.put("ret", 0);
			rMap.put("info", "登录成功");
			httpSession.setAttribute("admin", username);
			logger.info("checkLoginUser--" + username + " login success.");
		} else {
			rMap.put("ret", 1);
			rMap.put("info", "用户名或密码错误");
			logger.info("checkLoginUser--" + username + " login fail.");
		}
		return rMap;
	}
	
	//注销
	/*@RequestMapping(value = "/checkLogoutUser")
	public @ResponseBody void ckLogoutUser(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
	}*/
	
	@RequestMapping(value = "/checkLogoutUser")
	public @ResponseBody Json ckLogoutUser(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		Json j = new Json();
		j.setSuccess(true);
		return j;
	}
	
}
