package com.iteacher.news.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class News {
    private Integer newsid;

    private String title;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date addtime;

    private String type;

    private Integer scholid;

    private String recipient;

    private String picture;

    private String content;

    private String userid;

    private String abstr;

    private String tag;
    
    private String url;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getScholid() {
        return scholid;
    }

    public void setScholid(Integer scholid) {
        this.scholid = scholid;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient == null ? null : recipient.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getAbstr() {
        return abstr;
    }

    public void setAbstr(String abstr) {
        this.abstr = abstr == null ? null : abstr.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

	@Override
	public String toString() {
		return "News [newsid=" + newsid + ", title=" + title + ", addtime=" + addtime + ", type=" + type + ", scholid=" + scholid + ", recipient=" + recipient + ", picture=" + picture + ", content=" + content + ", userid=" + userid + ", abstr=" + abstr + ", tag=" + tag + ", url=" + url + "]";
	}
    
}