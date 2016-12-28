package com.iteacher.schoolcourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteacher.contact.dao.CampusMapper;
import com.iteacher.contact.dao.SchoolMapper;
import com.iteacher.contact.model.Campus;
import com.iteacher.contact.model.School;
import com.iteacher.schoolcourse.model.SchoolCustom;
import com.iteacher.schoolcourse.model.SchoolVo;

/**
 * @author xiaozhou
 * @date 2016年7月31日 下午4:27:49
 * 类说明
 */

@Service
public class SchoolCourseServiceImpl implements SchoolCourseService {
	@Autowired
	private SchoolMapper schoolMapper;
	@Autowired
	private CampusMapper campusMapper;
	
	//获取学校列表
	@Override
	public List<SchoolCustom> getAllLlist(SchoolVo schoolVo) {
		// TODO Auto-generated method stub
		return campusMapper.selectAllList(schoolVo);
	}

	//获取学校数目
	@Override
	public Long getSchoolCount(SchoolVo schoolVo) {
		// TODO Auto-generated method stub
		return campusMapper.getAllCount(schoolVo);
	}

	//行编辑，添加学校返回学校id
	@Override
	public int saveSchool(School school) {
		// TODO Auto-generated method stub
		return schoolMapper.insertSelective(school);
	}

	//行编辑，添加校区
	@Override
	public void saveCampus(Campus campus) {
		// TODO Auto-generated method stub
		campusMapper.insertSelective(campus);
	}

	//行编辑，修改校区信息（开学时间）
	@Override
	public void updateCampus(Campus campus) {
		// TODO Auto-generated method stub
		campusMapper.updateByPrimaryKeySelective(campus);
	}

	//添加学校之前查询学校是否存在
	@Override
	public School getSchool(String schoolname) {
		// TODO Auto-generated method stub
		return schoolMapper.getSchool(schoolname);
	}

	//查询校区数目
	@Override
	public int getCampusCount(int asid) {
		// TODO Auto-generated method stub
		return campusMapper.getCountBySchoolid(asid);
	}

	//删除校区
	@Override
	public void deleteCampus(int aid) {
		// TODO Auto-generated method stub
		campusMapper.deleteByPrimaryKey(aid);
	}

	//删除校区和对应的学校
	@Override
	public void deleteCampusAndSchool(int aid) {
		// TODO Auto-generated method stub
		campusMapper.deleteCampusAndSchool(aid);
	}


}
