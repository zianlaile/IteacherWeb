package com.iteacher.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {
	
	private static Logger logger = Logger.getLogger(LoginInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2) throws Exception {
		logger.info("LoginInterceptor--requestUri:" + arg0.getRequestURI() + ",contextPath:" + arg0.getContextPath());
		String admin = (String)arg0.getSession().getAttribute("admin");
		if (admin == null) {
			logger.info("LoginInterceptor--即将跳转到login页面！"); 
			arg1.sendRedirect(arg0.getContextPath() + "/login");
			return false;
		}
		return true;
	}

}
