package com.iteacher.contact.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iteacher.contact.model.Contact;
import com.iteacher.contact.model.ContactVo;

public interface ContactMapper {
    int deleteByPrimaryKey(Integer contactid);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer contactid);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);

	void insert(List<Contact> contacts);

	List<Contact> selectList(ContactVo contactVo);

	Long getAllCount(ContactVo contactVo);

	List<Contact> selectAllDepartment();

	void insertBatch(List<Contact> cts);

}