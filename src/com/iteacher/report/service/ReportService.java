package com.iteacher.report.service;

import java.util.List;

import com.iteacher.report.model.Report;
import com.iteacher.report.model.ReportCustom;


public interface ReportService {
	List<Report> getReportList(int page, int rows);
	int getAllReportCount();
	
	List<ReportCustom> getReportAndOthersList(int page, int rows);
}
