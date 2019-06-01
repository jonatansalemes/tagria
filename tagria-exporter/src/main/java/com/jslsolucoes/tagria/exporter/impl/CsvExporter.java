
package com.jslsolucoes.tagria.exporter.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.util.IOUtils;

import com.jslsolucoes.tagria.exporter.model.Column;
import com.jslsolucoes.tagria.exporter.model.Header;
import com.jslsolucoes.tagria.exporter.model.Row;
import com.jslsolucoes.tagria.exporter.model.Table;

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
		csv.append(headers.stream().collect(Collectors.joining(",")).concat(System.lineSeparator()));
	}

	private void body(StringBuilder csv) {
		for (Row row : table.getRows()) {
			List<String> lines = new ArrayList<>();
			for (Column column : row.getColumns()) {
				lines.add(column.getContent());
			}
			csv.append(lines.stream().collect(Collectors.joining(",")).concat(System.lineSeparator()));
		}
	}
}
