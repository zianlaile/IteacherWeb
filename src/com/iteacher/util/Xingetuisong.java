package com.iteacher.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.iteacher.user.model.StuAccount;
import com.iteacher.user.model.TeaAccount;
import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.MessageIOS;
import com.tencent.xinge.XingeApp;



public class Xingetuisong {
	
	public void message(int type,String userid, List<TeaAccount> allteachers, List<StuAccount> allstudents,String content,int newsid){
		
		String title="Iteacher";		
		String activityAndroid="com.li.zjut.iteacher";		//String activityAndroid="com.zhongtong.zhu.message.HuanXActivity";
		//String activityIOS="";
		
		
		if(type==XiaoxiType.NewsTypeNotification.getValue()){
			activityAndroid="com.li.zjut.iteacher";//通知页面 activityAndroid="com.zhongtong.zhu.message.HuanXActivity"
		}
			
		//该类提供与信鸽后台交互的接口。 构造函数有两个参，均为必选
		//XingeApp push = new XingeApp(accessId,secretKey);(2100208784,"922045258fe6ad9bf444b00ea210f10d")
		//accessId:推送目标应用id    secretKey:推送密钥
		
		//XingeApp pushIOS = new XingeApp(2200112690l, "922ecd6385c5ff0c274e2557ff1b0229");
		XingeApp pushAndroid = new XingeApp(2100203987, "ac7b84ec0e86c6b1260b5c9fcef59d20");
		
		
		Map<String, Object> custom=new HashMap<String,Object>();
		custom.put("type", type);
		//custom.put("messageid", messageid);
		custom.put("proid", newsid);
		
		//定义android推送消息
	    Message	message = new Message();
		message.setType(Message.TYPE_NOTIFICATION);
		ClickAction action = new ClickAction();
		action.setActionType(ClickAction.TYPE_ACTIVITY);
		action.setActivity(activityAndroid);
		message.setTitle(title);
		message.setContent(content);
		message.setAction(action);
		message.setCustom(custom);

		//定义IOS平台推送消息
		MessageIOS messageIOS = new MessageIOS();
		messageIOS.setCustom(custom);
		messageIOS.setAlert(content);
		messageIOS.setBadge(1);
		
		//System.out.println("这就算是推送到位了吧！！！！");
		//System.out.println("学生信息"+ allstudents.toString());
		//学生
/*		if(allstudents!=null){
			for(StuAccount s:allstudents){
				//发送
				System.out.println(s.getCid()+":"+s.getName());
				if(s.getDevice()!=null&&s.getCid()!=null&&!s.getCid().equals("null")){
					if(s.getDevice().equals(1)){
						//推送消息给单个设备(推送目标设备token, 消息体)
						System.out.println(pushAndroid.pushSingleDevice(s.getCid(), message));
					}else if(s.getDevice().equals(0)){
						//推送消息给单个设备(推送目标设备token, 消息体, ios专用)
						System.out.println("ios设备还没有到位");
						//System.out.println(pushIOS.pushSingleDevice(s.getCid(), messageIOS,XingeApp.IOSENV_DEV));
					}else{
						System.out.println("mobilesystem is null!");
					}
				}
			}
		}*/
		//教师
		if(allstudents!=null){
			System.out.println(message.toJson());
			for(TeaAccount s:allteachers){
				//发送
				System.out.println(s.getCid()+":"+s.getName());
				if(s.getDevice()!=null&&s.getCid()!=null&&!s.getCid().equals("null")){
					if(s.getDevice().equals(1)){
						//推送消息给单个设备(推送目标设备token, 消息体)
						System.out.println("安卓推送：" + s.getId() + " , " + pushAndroid.pushSingleDevice(s.getCid(), message));
					}else if(s.getDevice().equals(0)){
						//推送消息给单个设备(推送目标设备token, 消息体, ios专用)
						System.out.println("IOS推送：" + "ios设备还没有到位");
						//System.out.println(pushIOS.pushSingleDevice(s.getCid(), messageIOS,XingeApp.IOSENV_DEV));
					}else{
						System.out.println(s.getId() + " , " + "mobilesystem is null!");
					}
				}
			}
		}
	}
}
