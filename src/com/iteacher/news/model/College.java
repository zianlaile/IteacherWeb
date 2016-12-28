package com.iteacher.news.model;

public class College {
    private Integer id;

    private String collegename;

    private Integer campusid;

    private Integer parentCollegeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename == null ? null : collegename.trim();
    }

    public Integer getCampusid() {
        return campusid;
    }

    public void setCampusid(Integer campusid) {
        this.campusid = campusid;
    }

    public Integer getParentCollegeid() {
        return parentCollegeid;
    }

    public void setParentCollegeid(Integer parentCollegeid) {
        this.parentCollegeid = parentCollegeid;
    }
}