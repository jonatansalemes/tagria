
package com.jslsolucoes.tagria.lib.grid.exporter.model;

import java.util.List;

public class Table {
	private String title;
	private List<Header> headers;
	private List<Row> rows;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
}
