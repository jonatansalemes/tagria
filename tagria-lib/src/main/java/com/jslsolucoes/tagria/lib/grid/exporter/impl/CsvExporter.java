
package com.jslsolucoes.tagria.lib.grid.exporter.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.IOUtils;

import com.jslsolucoes.tagria.lib.grid.exporter.model.Column;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Header;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Row;
import com.jslsolucoes.tagria.lib.grid.exporter.model.Table;

public class CsvExporter {
	private Table table;

	public CsvExporter(Table table) {
		this.table = table;
	}

	public void doExport(OutputStream outputStream) throws IOException {
		IOUtils.copy(export(), outputStream);
	}

	private ByteArrayInputStream export() {
		StringBuilder csv = new StringBuilder();
		header(csv);
		body(csv);
		return new ByteArrayInputStream(csv.toString().getBytes());
	}

	private void header(StringBuilder csv) {

		List<String> headers = new ArrayList<>();
		for (Header header : table.getHeaders()) {
			headers.add(header.getContent());
		}
		csv.append(StringUtils.join(headers.toArray(), ",").concat(System.lineSeparator()));
	}

	private void body(StringBuilder csv) {

		for (Row row : table.getRows()) {
			List<String> line = new ArrayList<>();
			for (Column column : row.getColumns()) {
				line.add(column.getContent());
			}
			csv.append(StringUtils.join(line.toArray(), ",").concat(System.lineSeparator()));
		}
	}
}
