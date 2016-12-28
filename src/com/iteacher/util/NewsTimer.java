package com.iteacher.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;


import com.iteacher.user.model.StuAccount;
import com.iteacher.user.model.TeaAccount;

public class NewsTimer {

	private int newsid;
	private String content;
	private Date time;
	private String useid;	//发布者
	private List<TeaAccount> allteachers;
	private List<StuAccount> allstudents;
	private static Boolean isrunning=false;
	private static Map<Integer, Timer> map = new HashMap<Integer, Timer>();
	public NewsTimer(int newsid,String content,Date time,String useid,List<TeaAccount> allteachers,List<StuAccount> allstudents){
		this.newsid=newsid;
		this.content=content;
		this.time=time;
		this.useid=useid;
		this.allteachers=allteachers;
		this.allstudents=allstudents;
	}
	
	public void starttimer(){
		Timer timer = new Timer();
		NewsTimerTasker newsTimerTasker = new NewsTimerTasker(newsid,content,useid,allteachers,allstudents);
		timer.schedule(newsTimerTasker, time);
		map.put(newsid, timer);
		isrunning=true;
	}
	public void stoptimer(){
		if(isrunning){
			map.get(newsid).cancel();
			map.remove(newsid);
		}
	}
}
