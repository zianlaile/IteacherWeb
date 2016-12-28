package com.iteacher.report.model;

import java.util.Date;

public class Bus {
    private Integer busid;

    private Integer campusid;

    private Integer buspicid;

    private String userid;

    private String username;

    private Date addtime;

    private String schoolyear;

    private Integer agree_num;

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    public Integer getCampusid() {
        return campusid;
    }

    public void setCampusid(Integer campusid) {
        this.campusid = campusid;
    }

    public Integer getBuspicid() {
        return buspicid;
    }

    public void setBuspicid(Integer buspicid) {
        this.buspicid = buspicid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear == null ? null : schoolyear.trim();
    }

	public Integer getAgree_num() {
		return agree_num;
	}

	public void setAgree_num(Integer agree_num) {
		this.agree_num = agree_num;
	}


}