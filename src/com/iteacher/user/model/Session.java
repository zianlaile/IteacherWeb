package com.iteacher.user.model;

public class Session {
	private int id;
	private String sessionid;
	private String userid;
	private int last_online;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getLast_online() {
		return last_online;
	}
	public void setLast_online(int last_online) {
		this.last_online = last_online;
	}
}

