package com.iteacher.util;

public enum XiaoxiType {
    //通知
    NewsTypeNotification("新的通知",0),    
    
    //新鲜事
    NewsTypeInformation("新鲜事",1);
	
	//学院通知
	
    
    private String name;
    private int value;
    private XiaoxiType(String name,int value) {
		// TODO Auto-generated constructor stub
    	this.name=name;
    	this.value=value;
	}
    public String getName() {
		return name;
	}
    public int getValue(){
    	return value;
    }
}
