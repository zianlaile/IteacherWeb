package com.iteacher.user.model;

public class TeaAccount {
    private Integer id;

    private String userid;

    private Integer schoolid;

    private String teaNumber;

    private String password;

    private String imToken;

    private Integer device;

    private String cid;

    private String picid;

    private String email;

    private Integer campusid;

    private Integer collegeid;

    private String phone;

    private Integer type;

    private Integer role;

    private Integer institutionid;

    private String qq;

    private String shortPhone;

    private String office;

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

    public String getTeaNumber() {
        return teaNumber;
    }

    public void setTeaNumber(String teaNumber) {
        this.teaNumber = teaNumber == null ? null : teaNumber.trim();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(Integer institutionid) {
        this.institutionid = institutionid;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getShortPhone() {
        return shortPhone;
    }

    public void setShortPhone(String shortPhone) {
        this.shortPhone = shortPhone == null ? null : shortPhone.trim();
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office == null ? null : office.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "TeaAccount [id=" + id + ", userid=" + userid + ", schoolid=" + schoolid + ", teaNumber=" + teaNumber + ", password=" + password + ", imToken=" + imToken + ", device=" + device + ", cid=" + cid + ", picid=" + picid + ", email=" + email + ", campusid=" + campusid + ", collegeid=" + collegeid + ", phone=" + phone + ", type=" + type + ", role=" + role + ", institutionid=" + institutionid + ", qq=" + qq + ", shortPhone=" + shortPhone + ", office=" + office + ", name=" + name + "]";
	}
    
}