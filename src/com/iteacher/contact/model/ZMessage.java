package com.iteacher.contact.model;

import java.util.Date;

public class ZMessage {
	private Integer message_id;
	private String user_id;
	private Integer type;
	private Date add_time;
	private String content;
	private String pro_stringid;
	private Integer pro_intid;
	public Integer getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPro_stringid() {
		return pro_stringid;
	}
	public void setPro_stringid(String pro_stringid) {
		this.pro_stringid = pro_stringid;
	}
	public Integer getPro_intid() {
		return pro_intid;
	}
	public void setPro_intid(Integer pro_intid) {
		this.pro_intid = pro_intid;
	}

	
}
