package com.iteacher.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteacher.contact.dao.CampusMapper;
import com.iteacher.contact.dao.ContactMapper;
import com.iteacher.contact.dao.ContacttempMapper;
import com.iteacher.contact.dao.SchoolMapper;
import com.iteacher.contact.model.Campus;
import com.iteacher.contact.model.Contact;
import com.iteacher.contact.model.ContactVo;
import com.iteacher.contact.model.Contacttemp;
import com.iteacher.contact.model.School;
import com.iteacher.util.pNews;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactMapper contactMapper;
	@Autowired
	private ContacttempMapper contacttempMapper;
	@Autowired
	private SchoolMapper schoolMapper;
	@Autowired
	private CampusMapper campusMapper;
	
	
	
	@Override
	
	//导入前清空temp表
	public void deleteallcontacttemp() {
		contacttempMapper.deleteAll();
		
	}
	
	//保存数据到temp表
	@Override
	public void saveImportContact(Contacttemp contacttemp) {
		contacttempMapper.insertSelective(contacttemp);
		
	}
	
	//获取temp表中的数据
	@Override
	public List<Contacttemp> getAllContacts() {
		return contacttempMapper.selectAll();
	}
	
	//获取school表中信息
	@Override
	public List<School> getAllSchool() {
		return schoolMapper.select();
	}
	
	//根据学校获取校区
	@Override
	public List<Campus> getAllCampusBySchoolid(int schoolid) {
		return campusMapper.selectBySchoolid(schoolid);
	}

	//保存数据到contact表
	@Override
	public void saveContact(Contact ct) {
		contactMapper.insertSelective(ct);
		
	}

	//contactList
	@Override
	public List<Contact> getAllList(ContactVo contactVo) {
		return contactMapper.selectList(contactVo);
		//(page.getPage()-1)*page.getRows(),page.getRows(),
	}

	//contactList的数目
	@Override
	public Long getAllContactCount(ContactVo contactVo) {
		// TODO Auto-generated method stub
		return contactMapper.getAllCount(contactVo);
	}

	//行编辑，修改数据，updata数据
	@Override
	public void updataContact(Contact contact) {
		contactMapper.updateByPrimaryKeySelective(contact);
		
	}

	//行编辑，删除一行记录
	@Override
	public void deleteContactById(int aid) {
		contactMapper.deleteByPrimaryKey(aid);
		
	}

	//获取所有的学院部门
	@Override
	public List<Contact> getAllDepartment() {
		return contactMapper.selectAllDepartment();
	}

	@Override
	public void saveImportContactBatch(List<Contacttemp> contacttemps) {
		contacttempMapper.insertBatch(contacttemps);
	}

	@Override
	public void saveBatch(List<Contact> cts) {
		contactMapper.insertBatch(cts);
	}
	
}

