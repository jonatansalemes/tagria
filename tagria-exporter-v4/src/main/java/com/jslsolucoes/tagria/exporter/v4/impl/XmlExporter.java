
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

    private byte[] title(String title, String encoding) throws UnsupportedEncodingException {
	return ("<title>" + title + "</title>").getBytes(encoding);
    }

    private byte[] header(List<Header> headers, String encoding) throws UnsupportedEncodingException {
	return headers.stream()
		.map(header -> "<column align=\"" + header.getAlign() + "\">" + header.getContent() + "</column>")
		.collect(Collectors.joining()).getBytes(encoding);
    }

    private byte[] row(Row row, String encoding) throws UnsupportedEncodingException {
	return row.getColumns().stream()
		.map(column -> "<column align=\"" + column.getAlign() + "\">" + column.getContent() + "</column>")
		.collect(Collectors.joining()).getBytes(encoding);
    }

    private byte[] init(String encoding) throws UnsupportedEncodingException {
	return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes(encoding);
    }

    private byte[] tableStart(String encoding) throws UnsupportedEncodingException {
	return "<table>".getBytes(encoding);
    }

    private byte[] tableEnd(String encoding) throws UnsupportedEncodingException {
	return "</table>".getBytes(encoding);
    }

    private byte[] headerStart(String encoding) throws UnsupportedEncodingException {
	return "<header>".getBytes(encoding);
    }

    private byte[] headerEnd(String encoding) throws UnsupportedEncodingException {
	return "</header>".getBytes(encoding);
    }

    private byte[] bodyStart(String encoding) throws UnsupportedEncodingException {
	return "<body>".getBytes(encoding);
    }

    private byte[] bodyEnd(String encoding) throws UnsupportedEncodingException {
	return "</body>".getBytes(encoding);
    }

    @Override
    public byte[] export(ExporterContext exporterContext) {
	Table table = exporterContext.getTable();
	String encoding = exporterContext.getEncoding();
	try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
	    byteArrayOutputStream.write(init(encoding));
	    byteArrayOutputStream.write(tableStart(encoding));
	    byteArrayOutputStream.write(title(table.getTitle(), encoding));
	    byteArrayOutputStream.write(headerStart(encoding));
	    byteArrayOutputStream.write(header(table.getHeaders(), encoding));
	    byteArrayOutputStream.write(headerEnd(encoding));
	    byteArrayOutputStream.write(bodyStart(encoding));
	    for (Row row : table.getRows()) {
		byteArrayOutputStream.write(row(row, encoding));
	    }
	    byteArrayOutputStream.write(bodyEnd(encoding));
	    byteArrayOutputStream.write(tableEnd(encoding));
	    return byteArrayOutputStream.toByteArray();
	} catch (IOException e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    @Override
    public String contentType(String encoding) {
	return "text/xml;charset=" + encoding;
    }

    @Override
    public Boolean accepts(String mediaType) {
	return "xml".equals(mediaType);
    }
}
