package com.iteacher.news.dao;

import com.iteacher.news.model.Pic;

public interface PicMapper {
    int deleteByPrimaryKey(Integer picid);

    int insert(Pic record);

    int insertSelective(Pic record);

    Pic selectByPrimaryKey(Integer picid);

    int updateByPrimaryKeySelective(Pic record);

    int updateByPrimaryKey(Pic record);

    //按picture查找picid
	int selectByPic(String finalName);
}