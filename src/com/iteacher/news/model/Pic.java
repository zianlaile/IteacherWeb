package com.iteacher.news.model;

import java.util.Date;

public class Pic {
    private Integer picid;

    private Date addtime;

    private String picture;

    private String compresspicture;

    private String intro;

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getCompresspicture() {
        return compresspicture;
    }

    public void setCompresspicture(String compresspicture) {
        this.compresspicture = compresspicture == null ? null : compresspicture.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}