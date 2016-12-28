package com.iteacher.user.dao;

import java.util.List;

import com.iteacher.user.model.TeaAccount;

public interface TeaAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeaAccount record);

    int insertSelective(TeaAccount record);

    TeaAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeaAccount record);

    int updateByPrimaryKey(TeaAccount record);

	List<TeaAccount> selectTea(Integer college_id);
}