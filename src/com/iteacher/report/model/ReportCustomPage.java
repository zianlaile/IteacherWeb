package com.iteacher.report.model;

import java.util.List;

public class ReportCustomPage {

	private int total;
	private List<ReportCustom> rows;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<ReportCustom> getRows() {
		return rows;
	}
	public void setRows(List<ReportCustom> rows) {
		this.rows = rows;
	}

}
