package com.iteacher.user.model;

import java.util.List;

public class SessionPage {
	private int total;
	private List<Session> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Session> getRows() {
		return rows;
	}
	public void setRows(List<Session> rows) {
		this.rows = rows;
	}
}
