package com.iteacher.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteacher.report.dao.ReportMapper;
import com.iteacher.report.model.Report;
import com.iteacher.report.model.ReportCustom;



@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportMapper reportMapper;

	@Override
	public List<Report> getReportList(int page, int rows) {
		return reportMapper.findReportList((page - 1)*rows, rows);
	}

	@Override
	public int getAllReportCount() {
		return reportMapper.countAllReport();
	}

	@Override
	public List<ReportCustom> getReportAndOthersList(int page, int rows) {
		return reportMapper.findReportListAndOthers((page - 1)*rows, rows);
	}

}
