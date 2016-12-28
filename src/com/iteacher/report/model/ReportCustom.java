package com.iteacher.report.model;

//通过这个类映射校车图片举报的一系列信息
public class ReportCustom extends Report{

	/*
	 * 添加g_bus的属性
	 * g_bus.agree_num,
	 */
	private Integer buspicid;
	private Integer agree_num;
	
	/*
	 * 添加g_pic的属性
	 */
	private Integer picid;
	private String picture;

	public Integer getBuspicid() {
		return buspicid;
	}
	public void setBuspicid(Integer buspicid) {
		this.buspicid = buspicid;
	}

	public Integer getAgree_num() {
		return agree_num;
	}
	public void setAgree_num(Integer agree_num) {
		this.agree_num = agree_num;
	}
	public Integer getPicid() {
		return picid;
	}
	public void setPicid(Integer picid) {
		this.picid = picid;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
