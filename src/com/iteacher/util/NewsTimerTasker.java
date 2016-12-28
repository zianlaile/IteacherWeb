package com.iteacher.util;

import java.util.List;
import java.util.TimerTask;


import com.iteacher.user.model.StuAccount;
import com.iteacher.user.model.TeaAccount;

public class NewsTimerTasker extends TimerTask{
	private int newsid;
	private String content;
	private List<TeaAccount> allteachers; //接收者
	private List<StuAccount> allstudents; //接收者
	private String userid; //发布者

	public NewsTimerTasker(int newsid,String content,String userid, List<TeaAccount> allteachers, List<StuAccount> allstudents){
		this.newsid=newsid;
		this.content=content;
		this.userid=userid;
		this.allteachers=allteachers;
		this.allstudents=allstudents;
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Xingetuisong xingetuisong = new Xingetuisong();
		xingetuisong.message(XiaoxiType.NewsTypeNotification.getValue(), userid, allteachers, allstudents, content, newsid);
	}

}
