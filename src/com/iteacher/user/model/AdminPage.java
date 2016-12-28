package com.iteacher.user.model;

import java.util.List;

public class AdminPage {

	private int total;
	private List<Admin> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Admin> getRows() {
		return rows;
	}
	public void setRows(List<Admin> rows) {
		this.rows = rows;
	}

}
