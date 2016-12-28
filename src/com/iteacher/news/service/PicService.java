package com.iteacher.news.service;

import com.iteacher.news.model.Pic;


public interface PicService {
	
	
	void addpic(Pic pic);

	int findByPic(String finalName);

	

	/*List<News> getNewsList(pNews news);

	Long getAllNewsCount();*/
	/*
	 * List<Report> getReportList(int page, int rows);
	int getAllReportCount();
	 */

	

}
