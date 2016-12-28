package com.iteacher.user.model;

public class StuAccount {
    private Integer id;

    private String userid;

    private Integer schoolid;

    private String stuNumber;

    private String password;

    private String imToken;

    private Integer device;

    private String cid;

    private String picid;

    private String email;

    private String phone;

    private Integer phoneState;

    private Integer campusid;

    private Integer collegeid;

    private String dormitory;

    private String shortPhone;

    private String qq;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber == null ? null : stuNumber.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken == null ? null : imToken.trim();
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getPicid() {
        return picid;
    }

    public void setPicid(String picid) {
        this.picid = picid == null ? null : picid.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getPhoneState() {
        return phoneState;
    }

    public void setPhoneState(Integer phoneState) {
        this.phoneState = phoneState;
    }

    public Integer getCampusid() {
        return campusid;
    }

    public void setCampusid(Integer campusid) {
        this.campusid = campusid;
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory == null ? null : dormitory.trim();
    }

    public String getShortPhone() {
        return shortPhone;
    }

    public void setShortPhone(String shortPhone) {
        this.shortPhone = shortPhone == null ? null : shortPhone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "StuAccount [id=" + id + ", userid=" + userid + ", schoolid=" + schoolid + ", stuNumber=" + stuNumber + ", password=" + password + ", imToken=" + imToken + ", device=" + device + ", cid=" + cid + ", picid=" + picid + ", email=" + email + ", phone=" + phone + ", phoneState=" + phoneState + ", campusid=" + campusid + ", collegeid=" + collegeid + ", dormitory=" + dormitory + ", shortPhone=" + shortPhone + ", qq=" + qq + ", name=" + name + "]";
	}
    
}