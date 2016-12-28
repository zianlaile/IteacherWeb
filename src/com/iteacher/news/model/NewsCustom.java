package com.iteacher.news.model;
/**
 * 定制新鲜事的扩展类
 * @author xiaozhou
 * @date 2016年6月2日 下午9:19:03
 * 输出参数类型，即后台-->页面
 */
public class NewsCustom extends News {
	//可以添加新鲜事的扩展属性，即可以添加别的属性
	
	/*添加adm_account的属性*/
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
