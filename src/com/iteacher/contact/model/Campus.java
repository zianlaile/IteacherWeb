package com.iteacher.contact.model;

public class Campus {
    private Integer id;

    private Integer schoolid;

    private String campusname;

    private String weekbegindate;

    private String coursebegintime;

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
        this.campusname = campusname == null ? null : campusname.trim();
    }

    public String getWeekbegindate() {
        return weekbegindate;
    }

    public void setWeekbegindate(String weekbegindate) {
        this.weekbegindate = weekbegindate == null ? null : weekbegindate.trim();
    }

    public String getCoursebegintime() {
        return coursebegintime;
    }

    public void setCoursebegintime(String coursebegintime) {
        this.coursebegintime = coursebegintime == null ? null : coursebegintime.trim();
    }
}