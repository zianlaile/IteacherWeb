package com.iteacher.contact.dao;

import java.util.List;

import com.iteacher.contact.model.School;

public interface SchoolMapper {
    int deleteByPrimaryKey(Long id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);

	List<School> select();

	School getSchool(String schoolname);
}