package com.iteacher.report.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iteacher.report.model.Report;
import com.iteacher.report.model.ReportCustom;
import com.iteacher.report.model.ReportCustomPage;
import com.iteacher.report.model.ReportPage;
import com.iteacher.report.service.ReportService;

@Controller
@RequestMapping("/bus")
public class ReportController {
	private static Logger logger = Logger.getLogger(ReportController.class);
	
	@Autowired
	private ReportService reportService;
	
	
	@RequestMapping(value = "/report/list")
	public @ResponseBody ReportPage getReportList(int page, int rows) {
		ReportPage rp = new ReportPage();
		List<Report> list = reportService.getReportList(page, rows);
		rp.setRows(list);
		rp.setTotal(reportService.getAllReportCount());
		logger.info("/report/list--page:" + page + ",rows:" + rows);
		return rp;
	}
	
	@RequestMapping(value = "/reportAndOthers/list")
	public @ResponseBody ReportCustomPage getreportAndOthers(int page, int rows) {
		ReportCustomPage rcp = new ReportCustomPage();
		List<ReportCustom> list = reportService.getReportAndOthersList(page, rows);
		rcp.setRows(list);
		rcp.setTotal(reportService.getAllReportCount());
		logger.info("/reportAndOthers/list--page:" + page + ",rows:" + rows);
		return rcp;
	}
	
}
