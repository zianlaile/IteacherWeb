package com.iteacher.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteacher.news.dao.CollegeMapper;
import com.iteacher.news.dao.NewsMapper;
import com.iteacher.news.dao.TagMapper;
import com.iteacher.news.model.College;
import com.iteacher.news.model.News;
import com.iteacher.news.model.Tag;
import com.iteacher.user.dao.AdmMapper;
import com.iteacher.user.dao.StuAccountMapper;
import com.iteacher.user.dao.TeaAccountMapper;
import com.iteacher.user.model.Admin;
import com.iteacher.user.model.StuAccount;
import com.iteacher.user.model.TeaAccount;
import com.iteacher.util.pNews;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private TagMapper tagMapper;
	@Autowired
	private AdmMapper admMapper;
	@Autowired
	private CollegeMapper collegeMapper;
	@Autowired
	private TeaAccountMapper teaAccountMapper;
	@Autowired
	private StuAccountMapper stuAccountMapper;
	

	@Override
	public List<News> getNewsList(pNews news) {
		// TODO Auto-generated method stub
		return newsMapper.findNewsList((news.getPage()-1)*news.getRows(),news.getRows());
	}

	@Override
	public Long getAllNewsCount() {
		// TODO Auto-generated method stub
		return newsMapper.countAllNews();
	}

	@Override
	public int save(News news) {
		return newsMapper.insertSelective(news);
		
	}

	@Override
	public int saveTag(Tag tag) {
		// TODO Auto-generated method stub
		return tagMapper.insertSelective(tag);
	}

	@Override
	public Tag findByTag(java.lang.String a) {
		// TODO Auto-generated method stub
		return tagMapper.selectByTag(a);
	}

	@Override
	public boolean delete(int newsid) {
		// TODO Auto-generated method stub
		return newsMapper.deleteByPrimaryKey(newsid);
	}

	@Override
	public Admin findByuser(String usern) {
		// TODO Auto-generated method stub
		return admMapper.findByname(usern);
	}

	@Override
	public int findByTagBool(String a) {
		// TODO Auto-generated method stub
		return tagMapper.selectByTagBool(a);
	}

	@Override
	public News findByNewsId(Integer newsid) {
		// TODO Auto-generated method stub
		return newsMapper.selectByPrimaryKey(newsid);
	}

	@Override
	public List<Tag> getAllTags() {
		// TODO Auto-generated method stub
		return tagMapper.getAllTags();
	}

	@Override
	public News getNewsById(int news_id) {
		// TODO Auto-generated method stub
		return newsMapper.selectWithUserByPrimaryKey(news_id);
	}

	@Override
	public void update(News news_now) {
		newsMapper.updateByPrimaryKeySelective(news_now);
		
	}

	@Override
	public List<College> getAllCollegeBySchoolid(int schoolid) {
		return collegeMapper.selectBySchoolid(schoolid);
	}

	@Override
	public List<TeaAccount> findTeacher(int college_id) {
		// TODO Auto-generated method stub
		return teaAccountMapper.selectTea(college_id);
	}

	@Override
	public List<StuAccount> findStudent(int college_id) {
		// TODO Auto-generated method stub
		return stuAccountMapper.selectStu(college_id);
	}

	
}

