package com.iteacher.news.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iteacher.news.model.College;
import com.iteacher.news.model.News;
import com.iteacher.news.model.Pic;
import com.iteacher.news.model.Tag;
import com.iteacher.news.service.NewsService;
import com.iteacher.news.service.PicService;
import com.iteacher.tpl.VelocityService;
import com.iteacher.user.model.Admin;
import com.iteacher.user.model.StuAccount;
import com.iteacher.user.model.TeaAccount;
import com.iteacher.util.CommonUtil;
import com.iteacher.util.DataGrid;
import com.iteacher.util.Json;
import com.iteacher.util.NewsTimer;
import com.iteacher.util.pNews;


@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;
	@Autowired
	private PicService picService;
	@Autowired
	private VelocityService velocityService;
	

	//String finalName = null;

	@RequestMapping("/list")
	@ResponseBody
	public DataGrid getNewsList(pNews news) {
		DataGrid dGrid = new DataGrid();
		List<News> list = newsService.getNewsList(news);
		dGrid.setRows(list);
		dGrid.setTotal(newsService.getAllNewsCount());

		return dGrid;
	}
	/**
	 * 添加标题图片
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	
	private static String UPLOAD_IMAGE_PATH;
	static{
		try {
			Properties props = new Properties();
			ResourceLoader resourceLoader = new DefaultResourceLoader();
			Resource resource = resourceLoader.getResource("classpath:config/config.properties");
			props.load(resource.getInputStream());
			UPLOAD_IMAGE_PATH = props.getProperty("image.path");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/addpic", method = RequestMethod.POST)
	public void addpic(MultipartHttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException {
		MultipartFile file = request.getFile("file");
		System.out.println("file的大小是："+file.getSize());
		if(file.getSize() > 716800){
			response.getWriter().write(0);
		}else{
			Pic pic = new Pic();
			// 原始文件名称
			String originalFilename = file.getOriginalFilename();
			// System.out.println(originalFilename);
			//String pic_path = request.getServletContext().getRealPath("/upload/pics");
			
			//String pic_path = "D:\\html\\";
			String newFileName = CommonUtil.getUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//创建新文件，固定目录
			String appPath = request.getServletContext().getRealPath(UPLOAD_IMAGE_PATH);
			System.out.println("这个是appPath---"+appPath);
			File dir  = new File(appPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File newFile = new File(dir, newFileName);
			//finalName = newFileName;
			// System.out.println(finalName);
			//File newFile = new File(pic_path + newFileName);
			//保存文件
			file.transferTo(newFile);
			pic.setPicture(newFileName);
			pic.setAddtime(new Date());
			pic.setIntro("标题图片");
	
			picService.addpic(pic);
			//返回文件路径到前台
			response.getWriter().write(newFileName);
		}
		

	}

	// 返回tag信息
	@RequestMapping("/chooseTag")
	@ResponseBody
	public List<Tag> chooseTag() {
		return newsService.getAllTags();
	}
	
	/**
	 * 添加新鲜事
	 * @param news
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public Json create(News news, String college,HttpSession session, MultipartHttpServletRequest request) {
		Json cJson = new Json();

		System.out.println(news.toString()+"学院："+college);
		
		/*if (newFileName != null) {
			news.setPicture(newFileName);
			newFileName = "";
		} else {
			news.setPicture(null);
		}*/

		//1.判断是否输入标签
		//2.判断标签中是否含有","，即是否是多个标签
	    //2.1 如果是多个标签用数组将其分别存储，并各个与数据库匹配是否存在，如果不存在存入数据库
		//3.如果只有一个标签，直接与数据库比对，同上 
		
		String tags = news.getTag();
		//System.out.println("-----------------------------------------"+tags);
		if(tags == " " || tags == null){
			
		}else{
			if (tags.contains(",")) {
				String[] tagArray = null;
				tagArray = tags.split(",");
				for (int i = 0; i < tagArray.length; i++) {
					if (newsService.findByTag(tagArray[i]) != null) {
						System.out.println(tagArray[i]);
					} else {
						Tag tag = new Tag();
						tag.setTag(tagArray[i]);
						newsService.saveTag(tag);
					}
				}
			}else{
				if(newsService.findByTag(tags) != null){
					System.out.println(tags);
				}else{
					Tag tag = new Tag();
					tag.setTag(tags);
					newsService.saveTag(tag);
				}
			}
			
		}

		// 根据用户名查找adm表，获取用户信息
		String usern = (String) session.getAttribute("admin");
		Admin admin = newsService.findByuser(usern);
		news.setUserid(admin.getUserid());
		news.setScholid(admin.getSchoolid());
		Date date_news = new Date();
		news.setAddtime(date_news);
		
			int insert_account = newsService.save(news);
			System.out.println("插入的结果"+insert_account);
			System.out.println(news.getNewsid());
			News news_now = newsService.getNewsById(news.getNewsid());
		try {	
			//存储url
			news_now.setUrl("http://localhost:8080/IteacherWeb/upload/html/news/"+news.getNewsid()+".html");
			newsService.update(news_now);
			
			cJson.setSuccess(true);
			cJson.setObj(news_now);
			cJson.setMsg("添加成功！");
		} catch (Exception e) {
			cJson.setMsg("添加失败！！！");
		}
		
		//生成静态html
		Map<String, Object> params = new HashMap<>();
		params.put("news", news);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		params.put("addtime",formatter.format(news.getAddtime()));
		String filePath = request.getServletContext().getRealPath("/upload/html/news");
		try {
			velocityService.parse("news.tpl", filePath + "/" + news.getNewsid() + ".html", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//推送
		int newsid = news.getNewsid();
		String content = "你收到了一条通知："+news.getTitle();
		Date time = new Date();
		String useid = admin.getUserid();
		//获取所有的信息接收者
		List<TeaAccount> allteachers = new ArrayList<TeaAccount>();
		List<StuAccount> allstudents = new ArrayList<StuAccount>();
		String recipients = news.getRecipient();
		if (college.contains(",")) {
			String[] collegeids = null;
			collegeids = college.split(",");
			/*if(recipients.contains("老师")){
				for (int i = 0; i < collegeids.length; i++) {
					//List<TeaAccount> teachers = new ArrayList<TeaAccount>();
					TeaAccount teacher = newsService.findTeacher(Integer.parseInt(collegeids[i]));
					allteachers.add(teacher);
					//allteachers.addAll(teachers);
					System.out.println("1:--"+collegeids[i]);
				}
			}
			if(college.contains("学生")){
				
			}
			*/
			for (int i = 0; i < collegeids.length; i++) {
				List<TeaAccount> teachers = new ArrayList<TeaAccount>();
				List<StuAccount> students = new ArrayList<StuAccount>();
				if(recipients.contains("老师")){
					teachers = newsService.findTeacher(Integer.parseInt(collegeids[i]));
					System.out.println("1:--"+collegeids[i]+" ...");
				}
				
				if (recipients.contains("学生")) {
					students = newsService.findStudent(Integer.parseInt(collegeids[i]));
					System.out.println("2:--"+collegeids[i]+" ...");
				}
				
				allteachers.addAll(teachers);
				allstudents.addAll(students);
			}
		}else{
			List<TeaAccount> teachers = new ArrayList<TeaAccount>();
			List<StuAccount> students = new ArrayList<StuAccount>();
			if(recipients.contains("老师")){
				teachers = newsService.findTeacher(Integer.parseInt(college));
				System.out.println("3:--"+college+" ...");
			}
			
			if (recipients.contains("学生")) {
				students = newsService.findStudent(Integer.parseInt(college));
				System.out.println("4:--"+college+" ...");
			}
			
			allteachers.addAll(teachers);
			allstudents.addAll(students);
			
		} 
		System.out.println(allteachers.toString()+allstudents.toString());
		if(allteachers.size()>0 || allstudents.size()>0){
			NewsTimer newsTimer = new NewsTimer(newsid, content, time, useid, allteachers, allstudents);
			newsTimer.starttimer();
		}
		
		
		
		
		return cJson;
	}

	// 删除新鲜事
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(int newsid) {
		newsService.delete(newsid);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		return j;
	}

	// 显示新鲜事详情
	@RequestMapping("/show")
	public String show(Integer newsid, Model model) {
		News news = newsService.findByNewsId(newsid);
		model.addAttribute(news);
		// System.out.println(news.getTime());
		return "news/news_show";
	}
	
	/**
	 * 根据学校，联动获取专业
	 */
	
	@RequestMapping("/chooseCollege")
	@ResponseBody
	public List<College> chooseCollege(int schoolid){
		return newsService.getAllCollegeBySchoolid(schoolid);
	}

}
