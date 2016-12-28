package com.iteacher.news.model;
/**
 * 新鲜事的包装对象
 * @author xiaozhou
 * @date 2016年6月2日 下午9:21:39
 * 输入的参数类型，即页面-->后台
 */
public class NewsVo {
	
	//这里包装所需要的查询条件

	private NewsCustom newsCustom;

	public NewsCustom getNewsCustom() {
		return newsCustom;
	}

	public void setNewsCustom(NewsCustom newsCustom) {
		this.newsCustom = newsCustom;
	}
}
