package com.iteacher.news.dao;

import java.util.List;

import com.iteacher.news.model.College;

public interface CollegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

	List<College> selectBySchoolid(int schoolid);
}