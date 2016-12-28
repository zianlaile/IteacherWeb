package com.iteacher.contact.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iteacher.contact.model.Campus;
import com.iteacher.contact.model.Contact;
import com.iteacher.contact.model.ContactVo;
import com.iteacher.contact.model.Contacttemp;
import com.iteacher.contact.model.School;
import com.iteacher.contact.service.ContactService;
import com.iteacher.util.DataGrid;
import com.iteacher.util.Json;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * @author xiaozhou
 * @date 2016年7月4日 下午5:01:59
 * 类说明 :添加学校，学院的联系人
 */

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired private ContactService contactService;
	
	/**
	 * 下载需要导入的模板
	 */
	@RequestMapping("/download")
	@ResponseBody
	public void download(HttpServletRequest request,HttpServletResponse response) throws Exception{
		/*
		 * 两个头一个流
		 * 1. Content-Type
		 * 2. Content-Disposition
		 * 3. 流：下载文件的数据
		 */
		String filepath = request.getRealPath("/WEB-INF/classes/templates/muban.xls");
		System.out.println(filepath);
		String filename = filepath;
		//String framename = filenameEncoding("模板.xls", request);
		//通过文件名称获取MIME类型
		String contentType = request.getServletContext().getMimeType(filename);
		String contentDisposition = "attachment;filename=Template.xls";
		// 一个流
		FileInputStream input = new FileInputStream(filename);
				
		//设置头
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);
				
		// 获取绑定了响应端的流
		ServletOutputStream output = response.getOutputStream();
		
		//把输入流中的数据写入到输出流中。
		IOUtils.copy(input, output);
				
		input.close();
	}
	
	/**
	 * 导入Excel 
	 */
	@RequestMapping(value = "/loadExcel", method = RequestMethod.POST)
	public void loadExcel(MultipartHttpServletRequest request, HttpServletResponse response, HttpSession session){
		//AjaxResponse ajaxResponse = AjaxResponse.instance();
		//从页面接收参数"fileInput"和JSP页面中file的id相同
		//System.out.println(" ---------------------------------------"+request.getParameter("school"));
		//System.out.println(" ---------------------------------------"+request.getParameter("campus"));
		String school = request.getParameter("school");
		String campus = request.getParameter("campus");
		MultipartFile file = request.getFile("fileInput");
		String originalFilename = file.getOriginalFilename();
		System.out.println(originalFilename);
		//清空缓存表
		contactService.deleteallcontacttemp();
		//输入流
		InputStream infile;
		try {
			infile = file.getInputStream();
			//response.getWriter().write("1");
		
			Contacttemp contacttemp = null;
			Workbook book = Workbook.getWorkbook(infile);
		
			Sheet sheet = book.getSheet(0);
            int rowCount = sheet.getRows();
            System.out.println("Excel一共有 " + rowCount + " 行数据");
            
            /*//保存学校
            String school = null;
            //保存校区
            String xq = null;*/
            List<Contacttemp> contacttemps = new ArrayList<>();
            for(int i=1; i<rowCount; i++){
            	contacttemp = new Contacttemp();
            	Cell[] cells = sheet.getRow(i);
            	contacttemp.setSchool(school);
            	contacttemp.setCampus(campus);
            	//校级部门或者学院级部门
            	String i_classify = cells[0].getContents();
            	if (i_classify == null || i_classify == "" ) {
					contacttemp.setNotes("信息有误class1");
					contacttemp.setClassify(null);
				}else if (!i_classify.equals("校级部门")  && !i_classify.equals("学院级部门")) {
					contacttemp.setNotes("信息有误class2");
					contacttemp.setClassify(i_classify);
					System.out.println("i_classify:"+i_classify + " notes:" + contacttemp.getNotes());
				}else {
					contacttemp.setClassify(i_classify);
				}
            	//具体的学院或部门
            	String  i_department = cells[1].getContents();
            	if (i_department == null || i_department == "") {
					contacttemp.setNotes("信息有误department");
					contacttemp.setDepartment(null);
				}else {
					contacttemp.setDepartment(i_department);
				}
            	//办公室
            	String i_office = cells[2].getContents();
            	if(i_office ==  null || i_office == ""){
            		contacttemp.setNotes("信息有误office");
            	}else {
					contacttemp.setOffice(i_office);
				}
            	//联系人
            	String i_person = cells[3].getContents();
            	if(i_person == null || i_person == ""){
            		contacttemp.setNotes("信息有误person");
            	}else {
					contacttemp.setPerson(i_person);
				}
            	//联系电话
            	String i_phone = cells[4].getContents();
            	if (i_phone == null || i_phone == "") {
					contacttemp.setNotes("信息有误phone");
				}else {
					contacttemp.setPhone(cells[4].getContents());
				}
            	//将数据先存入List容器中
            	contacttemps.add(contacttemp);
            	//contactService.saveImportContact(contacttemp);
            	
            }
            contactService.saveImportContactBatch(contacttemps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write("1");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("导入成功啦啦");
	}
	
	/**
	 * 将缓存表中的数据展示到前台
	 */
	@RequestMapping("/showTemp")
	@ResponseBody
	public List<Contacttemp> showTemp(){
		return contactService.getAllContacts();
	}
	
	/**
	 *  返回school信息
	 */
	@RequestMapping("/chooseSchool")
	@ResponseBody
	public List<School> chooseSchool() {
		return contactService.getAllSchool();
	}
	/**
	 * 根据学校，联动查询校区chooseCampus
	 */
	@RequestMapping("/chooseCampus")
	@ResponseBody
	public List<Campus> chooseCampus(int schoolid){
		System.out.println(schoolid);
		return contactService.getAllCampusBySchoolid(schoolid);
	}
	
	@RequestMapping("/chooseCampusAdd")
	@ResponseBody
	public List<Campus> chooseCampusAdd(int schoolid){
		System.out.println(schoolid);
		return contactService.getAllCampusBySchoolid(schoolid);
	}
	
	/**
	 * 存入信息到contact表
	 */
	@RequestMapping("/importContact")
	@ResponseBody
	public Json importContact(){
		Json j = new Json();
		
		List<Contacttemp> contacttempList = contactService.getAllContacts(); 
		List<Contact> cts = new ArrayList<>();
		for(Contacttemp pe:contacttempList){
			Contact ct = new Contact();
			ct.setCampus(pe.getCampus());
			ct.setClassify(pe.getClassify());
			ct.setDepartment(pe.getDepartment());
			ct.setOffice(pe.getOffice());
			ct.setPerson(pe.getPerson());
			ct.setPhone(pe.getPhone());
			ct.setSchool(pe.getSchool());
			
			cts.add(ct);
			
			//contactService.saveContact(ct);
		}
		contactService.saveBatch(cts);
		
		
		//清空 缓存表
		contactService.deleteallcontacttemp();
		
		j.setSuccess(true);
		return j;
	}
	
	/**
	 * 取消 导入
	 */
	@RequestMapping("/clearContact")
	@ResponseBody
	public Json clearContact(){
		Json j = new Json();
		contactService.deleteallcontacttemp();
		
		j.setSuccess(true);
		return j;
	}
	
	/**
	 * 将contact表中的数据展示到前台
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public DataGrid showList(ContactVo contactVo){
		DataGrid dGrid = new DataGrid();
		int begin = (contactVo.getPage()-1)*contactVo.getRows();
		contactVo.setPage(begin);
		List<Contact> contacts = contactService.getAllList(contactVo);
		dGrid.setRows(contacts);
		dGrid.setTotal(contactService.getAllContactCount(contactVo));
		
		return dGrid;
	}
	
	/**
	 * listInsert
	 * 行编辑，添加一行数据
	 */
	@RequestMapping("/listInsert")
	@ResponseBody
	public Json listInsert(@RequestBody Contact contact){
		Json j = new Json();
		try {
			contactService.saveContact(contact);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg("添加失败！");
		}
		
		return j;
	}
	
	/**
	 * listUpdate
	 * 行编辑，修改一行数据
	 */
	@RequestMapping("/listUpdate")
	@ResponseBody
	public Json listUpdate(@RequestBody Contact contact){
		Json j = new Json();
		try {
			contactService.updataContact(contact);
			j.setSuccess(true);
			j.setMsg("修改成功！");
		} catch (Exception e) {
			j.setMsg("修改失败！");
		}
		
		return j;
	}
	
	/**
	 * listDelete
	 * 行编辑，删除一行或多行数据
	 */
	@RequestMapping("/listDelete")
	@ResponseBody
	public Json listDelete(@RequestParam String ids){
		Json j = new Json();
		try {
			if(ids.contains(",")){
				String[] idsList = ids.split(",");
				for(int i=0;i<idsList.length;i++){
					int aid = Integer.parseInt(idsList[i]);
					contactService.deleteContactById(aid);
				}
			}else{
				 int bid = Integer.parseInt(ids);
				 contactService.deleteContactById(bid);
			}
			j.setSuccess(true);
		} catch (Exception e) {
			j.setSuccess(false);
		}
		
		System.out.println(ids);
		
		return j;
	}
	
	/**
	 * 选择部门学院
	 * chooseDepartment
	 */
	@RequestMapping("/chooseDepartment")
	@ResponseBody
	public List<Contact> chooseDepartment() {
		return contactService.getAllDepartment();
	}
	
	
	
}