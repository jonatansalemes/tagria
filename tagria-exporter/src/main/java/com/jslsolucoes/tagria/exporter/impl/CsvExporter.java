
package com.jslsolucoes.tagria.exporter.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.jslsolucoes.tagria.exception.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.parser.model.Header;
import com.jslsolucoes.tagria.exporter.parser.model.Row;
import com.jslsolucoes.tagria.exporter.parser.model.Table;

public class CsvExporter implements Exporter {

	private byte[] header(List<Header> headers) {
		return headers.stream().map(header -> header.getContent()).collect(Collectors.joining(",")).getBytes();
	}

	private byte[] row(Row row) {
		return row.getColumns().stream().map(column -> column.getContent()).collect(Collectors.joining(",")).getBytes();
	}

	private byte[] newLine() {
		return System.lineSeparator().getBytes();
	}

	@Override
	public Boolean accepts(String mediaType) {
		return "csv".equals(mediaType);
	}

	@Override
	public byte[] export(Table table) {
		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
			byteArrayOutputStream.write(header(table.getHeaders()));
			byteArrayOutputStream.write(newLine());
			for (Row row : table.getRows()) {
				byteArrayOutputStream.write(row(row));
				byteArrayOutputStream.write(newLine());
			}
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			throw new TagriaRuntimeException(e);
		}
	}

	@Override
	public String contentType() {
		return "text/csv";
	}
}
