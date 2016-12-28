package com.iteacher.user.dao;

import java.util.List;

import com.iteacher.user.model.StuAccount;

public interface StuAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuAccount record);

    int insertSelective(StuAccount record);

    StuAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuAccount record);

    int updateByPrimaryKey(StuAccount record);

	List<StuAccount> selectStu(Integer college_id);
}