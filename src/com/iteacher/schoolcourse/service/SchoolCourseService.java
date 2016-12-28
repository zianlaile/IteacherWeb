package com.iteacher.schoolcourse.service;

import java.util.List;

import com.iteacher.contact.model.Campus;
import com.iteacher.contact.model.School;
import com.iteacher.schoolcourse.model.SchoolCustom;
import com.iteacher.schoolcourse.model.SchoolVo;

/**
 * @author xiaozhou
 * @date 2016年7月31日 下午4:26:31
 * 类说明
 */
public interface SchoolCourseService {

	List<SchoolCustom> getAllLlist(SchoolVo schoolVo);

	Long getSchoolCount(SchoolVo schoolVo);

	int saveSchool(School school);

	void saveCampus(Campus campus);

	void updateCampus(Campus campus);

	School getSchool(String schoolname);

	int getCampusCount(int asid);

	void deleteCampus(int aid);

	void deleteCampusAndSchool(int aid);


}
