package com.iteacher.news.service;

import java.util.List;

import com.iteacher.news.model.College;
import com.iteacher.news.model.News;
import com.iteacher.news.model.Tag;
import com.iteacher.user.model.Admin;
import com.iteacher.user.model.StuAccount;
import com.iteacher.user.model.TeaAccount;
import com.iteacher.util.pNews;

public interface NewsService {

	

	List<News> getNewsList(pNews news);

	Long getAllNewsCount();
	/*
	 * List<Report> getReportList(int page, int rows);
	int getAllReportCount();
	 */

	int save(News news);
	
	int saveTag(Tag tag);

	Tag findByTag(String a);

	boolean delete(int newsid);

	Admin findByuser(String usern);

	int findByTagBool(String a);

	News findByNewsId(Integer newsid);

	List<Tag> getAllTags();

	News getNewsById(int news_id);

	void update(News news_now);

	List<College> getAllCollegeBySchoolid(int schoolid);

	List<TeaAccount> findTeacher(int college_id);

	List<StuAccount> findStudent(int college_id);


}
