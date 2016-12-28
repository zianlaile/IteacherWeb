package com.iteacher.contact.model;

public class School {
    private Long id;

    private String schoolname;

    private Integer totalclassnum;

    private String introduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public Integer getTotalclassnum() {
        return totalclassnum;
    }

    public void setTotalclassnum(Integer totalclassnum) {
        this.totalclassnum = totalclassnum;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}