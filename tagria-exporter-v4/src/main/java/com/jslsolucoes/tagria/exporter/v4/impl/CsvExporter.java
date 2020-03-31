
package com.jslsolucoes.tagria.exporter.v4.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Header;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Row;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class CsvExporter implements Exporter {

    private byte[] header(List<Header> headers, String encoding) throws UnsupportedEncodingException {
	return headers.stream().map(header -> header.getContent()).collect(Collectors.joining(",")).getBytes(encoding);
    }

    private byte[] row(Row row, String encoding) throws UnsupportedEncodingException {
	return row.getColumns().stream().map(column -> column.getContent()).collect(Collectors.joining(","))
		.getBytes(encoding);
    }

    private byte[] newLine(String encoding) throws UnsupportedEncodingException {
	return System.lineSeparator().getBytes(encoding);
    }

    @Override
    public Boolean accepts(String mediaType) {
	return "csv".equals(mediaType);
    }

    @Override
    public byte[] export(ExporterContext exporterContext) {
	Table table = exporterContext.getTable();
	String encoding = exporterContext.getEncoding();
	try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
	    if ("utf-8".equals(encoding.toLowerCase())) {
		byteArrayOutputStream.write(0xEF);
		byteArrayOutputStream.write(0xBB);
		byteArrayOutputStream.write(0xBF);
	    }
	    byteArrayOutputStream.write(header(table.getHeaders(), encoding));
	    byteArrayOutputStream.write(newLine(encoding));
	    for (Row row : table.getRows()) {
		byteArrayOutputStream.write(row(row, encoding));
		byteArrayOutputStream.write(newLine(encoding));
	    }
	    return byteArrayOutputStream.toByteArray();
	} catch (IOException e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    @Override
    public String contentType(String encoding) {
	return "text/csv;charset=" + encoding;
    }

}
