package com.iteacher.news.dao;

import java.util.List;

import com.iteacher.news.model.News;
import com.iteacher.util.pNews;

public interface NewsMapper {
	boolean deleteByPrimaryKey(Integer newsid);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsid);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    //查找新鲜事数量
	Long countAllNews();
	//分页查询新鲜事
	List<News> findNewsList(int i, int rows);
	//查询所有数据和用户名
	News selectWithUserByPrimaryKey(int news_id);
}