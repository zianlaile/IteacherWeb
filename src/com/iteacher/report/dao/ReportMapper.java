package com.iteacher.report.dao;

import java.util.List;

import com.iteacher.report.model.Report;
import com.iteacher.report.model.ReportCustom;

public interface ReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);
    
    List<Report> findReportList(int offset, int limit);
    int countAllReport();
    
    List<ReportCustom> findReportListAndOthers(int offset, int limit);
}