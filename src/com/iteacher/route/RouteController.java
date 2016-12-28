package com.iteacher.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class RouteController {
	@RequestMapping("/login")
	public String userLogin(){
		return "sys/login";
	}
	
	@RequestMapping("/log")
	public String userLog(){
		return "sys/log";
	}
	
	@RequestMapping("/sessionIndex")
	public String menuSession(){
		return "menu/index_session";
	}
	
	@RequestMapping("/AdminIndex")
	public String menuAdmin(){
		return "menu/index_admin";
	}
	
	@RequestMapping("/Index")
	public String Index(){
		return "index";
	}
	
	@RequestMapping("/North")
	public String layoutNorth(){
		return "layout/north";
	}
	
	@RequestMapping("/West")
	public String layoutWest(){
		return "layout/west";
	}
	
	@RequestMapping("/Center")
	public String layoutCenter(){
		return "layout/center";
	}
	
	@RequestMapping("/Porta")
	public String Porta(){
		return "layout/porta";
	}
	
	@RequestMapping("/Yhxx")
	public String menuYhxx(){
		return "menu/yhxx";
	}
	
	@RequestMapping("/Sessionxx")
	public String menuSessionxx(){
		return "menu/sessionxx";
	}
	
	@RequestMapping("/Xcsh")
	public String menuXcsh(){
		return "menu/xcsh";
	}
	
	@RequestMapping("/NewsList")
	public String news_NewsList(){
		return "news/news_list";
	}
	
	@RequestMapping("/NewsAdd")
	public String news_NewsAdd(){
		return "news/news_add";
	}
	
	@RequestMapping("/ContactAdd")
	public String contact_Add(){
		return "contact/contact_add";
	}
	
	@RequestMapping("/ContactList")
	public String contact_List(){
		return "contact/contact_list";
	}
	
	@RequestMapping("/SchoolCourseList")
	public String school_course_List(){
		return "school/school_course_list";
	}
}
