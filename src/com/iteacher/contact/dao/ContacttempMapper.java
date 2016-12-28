package com.iteacher.contact.dao;

import java.util.List;

import com.iteacher.contact.model.Contacttemp;

public interface ContacttempMapper {
    int deleteByPrimaryKey(Integer contactid);

    int insert(Contacttemp record);

    int insertSelective(Contacttemp record);

    Contacttemp selectByPrimaryKey(Integer contactid);

    int updateByPrimaryKeySelective(Contacttemp record);

    int updateByPrimaryKey(Contacttemp record);
    
    //导入前清空temp表
	void deleteAll();

	List<Contacttemp> selectAll();

	void insertBatch(List<Contacttemp> contacttemps);
}