package com.iteacher.schoolcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iteacher.contact.model.Campus;
import com.iteacher.contact.model.School;
import com.iteacher.schoolcourse.model.SchoolCustom;
import com.iteacher.schoolcourse.model.SchoolVo;
import com.iteacher.schoolcourse.service.SchoolCourseService;
import com.iteacher.util.DataGrid;
import com.iteacher.util.Json;

/**
 * @author xiaozhou
 * @date 2016年7月31日 下午4:25:47
 * 类说明
 */

@Controller
@RequestMapping("/schoolCampus")
public class SchoolCourseController {
	//schoolCampus/showList
	
	@Autowired
	private SchoolCourseService schoolCourseService;
	
	/**
	 * 将学校校区信息展示到前台
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public DataGrid showList(SchoolVo schoolVo){
		DataGrid dGrid = new DataGrid();
		int begin = (schoolVo.getPage()-1)*schoolVo.getRows();
		schoolVo.setPage(begin);
		List<SchoolCustom> schoolCustoms = schoolCourseService.getAllLlist(schoolVo);
		dGrid.setRows(schoolCustoms);
		dGrid.setTotal(schoolCourseService.getSchoolCount(schoolVo));
		
		return dGrid;
	}
	
	/**
	 * 行编辑，添加一行信息
	 */
	
	@RequestMapping("/listInsert")
	@ResponseBody
	public Json listInsert(@RequestBody SchoolVo schoolVo){
		Json j = new Json();
		School school = new School();
		Campus campus = new Campus();
		
		try {
			if(schoolCourseService.getSchool(schoolVo.getSchoolname()) != null){
				school = schoolCourseService.getSchool(schoolVo.getSchoolname());
				System.out.println(school.getSchoolname());
				long scholid = school.getId();
				int school_id = (int)scholid;
				campus.setSchoolid(school_id);
				campus.setCampusname(schoolVo.getCampusname());
				campus.setWeekbegindate(schoolVo.getWeekbegindate());
				campus.setCoursebegintime(schoolVo.getCoursebegintime());
				schoolCourseService.saveCampus(campus);
			}else{
				school.setSchoolname(schoolVo.getSchoolname());
				int result = schoolCourseService.saveSchool(school);	//保存成功返回 "1"
				if(result == 1){
					long sid = school.getId();	//此时得到的是刚刚存入的主键
					int school_id = (int)sid;
					campus.setSchoolid(school_id);
					campus.setCampusname(schoolVo.getCampusname());
					campus.setWeekbegindate(schoolVo.getWeekbegindate());
					campus.setCoursebegintime(schoolVo.getCoursebegintime());
					schoolCourseService.saveCampus(campus);
				}
			}
			
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			// TODO: handle exception
			j.setMsg("添加失败！");
		}
		
		return j;
	}
	
	/**
	 * listUpdate
	 * 行编辑，修改一行数据
	 */
	@RequestMapping("/listUpdate")
	@ResponseBody
	public Json listUpdate(@RequestBody Campus campus){
		Json j = new Json();
		try {
			schoolCourseService.updateCampus(campus);
			j.setSuccess(true);
			j.setMsg("修改成功！");
		} catch (Exception e) {
			j.setMsg("修改失败！");
		}
		return j;
	}
	
	/**
	 * listDelete
	 */
	@RequestMapping("/listDelete")
	@ResponseBody
	public Json listDelete(@RequestParam String ids, @RequestParam String schoolids){
		Json j = new Json();
		System.out.println(ids+"-----------"+schoolids);
		
		try {
			if(ids.contains(",")){
				String[] idsList = ids.split(",");
				String[] schoolidsList = schoolids.split(",");
				for(int i=0;i<idsList.length;i++){
					int aid = Integer.parseInt(idsList[i]);
					int asid = Integer.parseInt(schoolidsList[i]);
					//获取校区的数量，如果数量大于1，那么只删除校区(根据schoolid获取校区数量)
					//如果校区数量为1，那么同时删除校区和对应 的学校
					int count_campus = schoolCourseService.getCampusCount(asid);
					System.out.println(count_campus+"---------11111111111111111");
					if(count_campus > 1){
						schoolCourseService.deleteCampus(aid);
					}else {
						schoolCourseService.deleteCampusAndSchool(aid);
					}
				}
			}else {
				int bid = Integer.parseInt(ids);
				int bsid = Integer.parseInt(schoolids);
				int count_campus = schoolCourseService.getCampusCount(bsid);
				if(count_campus > 1){
					schoolCourseService.deleteCampus(bid);
				}else {
					System.out.println("什么情侣");
					schoolCourseService.deleteCampusAndSchool(bid);
				}
			}
			
			j.setSuccess(true);
			
		} catch (Exception e) {
			j.setSuccess(false);
		}
		
		return j;
	}	
	
	
	
	
	

}
