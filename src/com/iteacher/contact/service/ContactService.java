package com.iteacher.contact.service;

import java.util.List;

import com.iteacher.contact.model.Campus;
import com.iteacher.contact.model.Contact;
import com.iteacher.contact.model.ContactVo;
import com.iteacher.contact.model.Contacttemp;
import com.iteacher.contact.model.School;
import com.iteacher.util.pNews;

public interface ContactService {

	void deleteallcontacttemp();

	void saveImportContact(Contacttemp contacttemp);

	List<Contacttemp> getAllContacts();

	List<School> getAllSchool();

	List<Campus> getAllCampusBySchoolid(int schoolid);


	void saveContact(Contact ct);

	List<Contact> getAllList(ContactVo contactVo);

	Long getAllContactCount(ContactVo contactVo);

	void updataContact(Contact contact);

	void deleteContactById(int aid);

	List<Contact> getAllDepartment();

	void saveImportContactBatch(List<Contacttemp> contacttemps);

	void saveBatch(List<Contact> cts);

	
}
