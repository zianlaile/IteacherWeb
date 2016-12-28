package com.iteacher.report.model;

import java.util.List;

public class ReportPage {

	private int total;
	private List<Report> rows;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Report> getRows() {
		return rows;
	}
	public void setRows(List<Report> rows) {
		this.rows = rows;
	}

}
