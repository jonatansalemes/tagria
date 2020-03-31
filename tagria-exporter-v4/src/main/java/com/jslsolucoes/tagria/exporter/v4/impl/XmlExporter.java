
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

public class XmlExporter implements Exporter {

    private byte[] title(String title, String charset) throws UnsupportedEncodingException {
	return ("<title>" + title + "</title>").getBytes(charset);
    }

    private byte[] header(List<Header> headers, String charset) throws UnsupportedEncodingException {
	return headers.stream()
		.map(header -> "<column align=\"" + header.getAlign() + "\">" + header.getContent() + "</column>")
		.collect(Collectors.joining()).getBytes(charset);
    }

    private byte[] row(Row row, String charset) throws UnsupportedEncodingException {
	return row.getColumns().stream()
		.map(column -> "<column align=\"" + column.getAlign() + "\">" + column.getContent() + "</column>")
		.collect(Collectors.joining()).getBytes(charset);
    }

    private byte[] init(String charset) throws UnsupportedEncodingException {
	return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes(charset);
    }

    private byte[] tableStart(String charset) throws UnsupportedEncodingException {
	return "<table>".getBytes(charset);
    }

    private byte[] tableEnd(String charset) throws UnsupportedEncodingException {
	return "</table>".getBytes(charset);
    }

    private byte[] headerStart(String charset) throws UnsupportedEncodingException {
	return "<header>".getBytes(charset);
    }

    private byte[] headerEnd(String charset) throws UnsupportedEncodingException {
	return "</header>".getBytes(charset);
    }

    private byte[] bodyStart(String charset) throws UnsupportedEncodingException {
	return "<body>".getBytes(charset);
    }

    private byte[] bodyEnd(String charset) throws UnsupportedEncodingException {
	return "</body>".getBytes(charset);
    }

    @Override
    public byte[] export(ExporterContext exporterContext) {
	Table table = exporterContext.getTable();
	String charset = exporterContext.getCharset();
	try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
	    byteArrayOutputStream.write(init(charset));
	    byteArrayOutputStream.write(tableStart(charset));
	    byteArrayOutputStream.write(title(table.getTitle(), charset));
	    byteArrayOutputStream.write(headerStart(charset));
	    byteArrayOutputStream.write(header(table.getHeaders(), charset));
	    byteArrayOutputStream.write(headerEnd(charset));
	    byteArrayOutputStream.write(bodyStart(charset));
	    for (Row row : table.getRows()) {
		byteArrayOutputStream.write(row(row, charset));
	    }
	    byteArrayOutputStream.write(bodyEnd(charset));
	    byteArrayOutputStream.write(tableEnd(charset));
	    return byteArrayOutputStream.toByteArray();
	} catch (IOException e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    @Override
    public String contentType() {
	return "text/xml";
    }

    @Override
    public Boolean accepts(String mediaType) {
	return "xml".equals(mediaType);
    }
}
