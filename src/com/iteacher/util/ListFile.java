package com.iteacher.util;

import java.io.File;

/**
 * @author xiaozhou
 * @date 2016年7月17日 上午10:19:02
 * 类说明
 */
public class ListFile {
	static public void main(String[] str)throws Exception{
		File f=new File("/E:/BaiduYunDownload/qaz/05");                 //新建文件实例
		File[] list=f.listFiles();        /* 此处获取文件夹下的所有文件 */
		int num = 0;
		for(int i=0;i<list.length;i++){
			 String oldName = list[i].getName();
			 String newName = "d"+String.format("%03d",i);
			 
			 list[i].renameTo(new File("E:\\BaiduYunDownload\\qaz\\05\\"+newName));
			 
			 //System.out.println(newName);
			System.out.println(oldName);
			File ff = new File("/E:/BaiduYunDownload/qaz/05/"+oldName);
			System.out.println(ff);
			File[] list1 = ff.listFiles();
			/*for(int j=0;j<list1.length;j++){
				String picName = list1[j].getName();
				//System.out.println(picName);
				
				String newPicName = oldName+String.format("%02d", j);
				list1[j].renameTo(new File("E:\\BaiduYunDownload\\TianshiNee\\"+oldName+"\\"+newPicName+".jpg"));
				
				//System.out.println(newPicName);
				num++;
			}*/
			 
			
			//System.out.println(list[i].getAbsolutePath());//打印全路径，可以更改为你自己需要的方法
			
		}
		
		System.out.println(num);
		}
}
