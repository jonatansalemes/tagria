
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

    private byte[] header(List<Header> headers, String charset) throws UnsupportedEncodingException {
	return headers.stream().map(header -> header.getContent()).collect(Collectors.joining(",")).getBytes(charset);
    }

    private byte[] row(Row row, String charset) throws UnsupportedEncodingException {
	return row.getColumns().stream().map(column -> column.getContent()).collect(Collectors.joining(","))
		.getBytes(charset);
    }

    private byte[] newLine(String charset) throws UnsupportedEncodingException {
	return System.lineSeparator().getBytes(charset);
    }

    @Override
    public Boolean accepts(String mediaType) {
	return "csv".equals(mediaType);
    }

    @Override
    public byte[] export(ExporterContext exporterContext) {
	Table table = exporterContext.getTable();
	String charset = exporterContext.getCharset();
	try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
	    byteArrayOutputStream.write(header(table.getHeaders(), charset));
	    byteArrayOutputStream.write(newLine(charset));
	    for (Row row : table.getRows()) {
		byteArrayOutputStream.write(row(row, charset));
		byteArrayOutputStream.write(newLine(charset));
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
