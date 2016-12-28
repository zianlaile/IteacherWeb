package com.iteacher.contact.dao;

import java.util.List;

import com.iteacher.contact.model.Campus;
import com.iteacher.schoolcourse.model.SchoolCustom;
import com.iteacher.schoolcourse.model.SchoolVo;

public interface CampusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Campus record);

    int insertSelective(Campus record);

    Campus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKey(Campus record);

	List<Campus> selectBySchoolid(int schoolid);

	List<SchoolCustom> selectAllList(SchoolVo schoolVo);

	Long getAllCount(SchoolVo schoolVo);

	int getCountBySchoolid(int asid);

	void deleteCampusAndSchool(int aid);
}