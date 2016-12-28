package com.iteacher.schoolcourse.model;
/**
 * @author xiaozhou
 * @date 2016年7月31日 下午4:34:52
 * 类说明
 */
public class SchoolVo {
	private String schoolname;
    private Integer id;

    private Integer schoolid;

    private String campusname;

    private String weekbegindate;

    private String coursebegintime;
    
    private int page;
   	private int rows;

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(Integer schoolid) {
		this.schoolid = schoolid;
	}

	public String getCampusname() {
		return campusname;
	}

	public void setCampusname(String campusname) {
		this.campusname = campusname;
	}

	public String getWeekbegindate() {
		return weekbegindate;
	}

	public void setWeekbegindate(String weekbegindate) {
		this.weekbegindate = weekbegindate;
	}

	public String getCoursebegintime() {
		return coursebegintime;
	}

	public void setCoursebegintime(String coursebegintime) {
		this.coursebegintime = coursebegintime;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
    

	
}
