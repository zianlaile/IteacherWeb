package com.iteacher.news.dao;

import java.util.List;

import com.iteacher.news.model.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tagid);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagid);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    //按tag查找标签
    Tag selectByTag(String tag);
    //按tag查询tag数目
	int selectByTagBool(String a);
	//获取所有标签
	List<Tag> getAllTags();
}