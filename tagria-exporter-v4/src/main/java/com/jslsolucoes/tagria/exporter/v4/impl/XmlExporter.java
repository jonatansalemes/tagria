
package com.jslsolucoes.tagria.exporter.v4.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Header;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Row;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class XmlExporter implements Exporter {

    private byte[] title(String title) {
	return ("<title>" + title + "</title>").getBytes();
    }

    private byte[] header(List<Header> headers) {
	return headers.stream()
		.map(header -> "<column align=\"" + header.getAlign() + "\">" + header.getContent() + "</column>")
		.collect(Collectors.joining()).getBytes();
    }

    private byte[] row(Row row) {
	return row.getColumns().stream()
		.map(column -> "<column align=\"" + column.getAlign() + "\">" + column.getContent() + "</column>")
		.collect(Collectors.joining()).getBytes();
    }

    private byte[] init() {
	return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes();
    }

    private byte[] tableStart() {
	return "<table>".getBytes();
    }

    private byte[] tableEnd() {
	return "</table>".getBytes();
    }

    private byte[] headerStart() {
	return "<header>".getBytes();
    }

    private byte[] headerEnd() {
	return "</header>".getBytes();
    }

    private byte[] bodyStart() {
	return "<body>".getBytes();
    }

    private byte[] bodyEnd() {
	return "</body>".getBytes();
    }

    @Override
    public byte[] export(Table table) {
	try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
	    byteArrayOutputStream.write(init());
	    byteArrayOutputStream.write(tableStart());
	    byteArrayOutputStream.write(title(table.getTitle()));
	    byteArrayOutputStream.write(headerStart());
	    byteArrayOutputStream.write(header(table.getHeaders()));
	    byteArrayOutputStream.write(headerEnd());
	    byteArrayOutputStream.write(bodyStart());
	    for (Row row : table.getRows()) {
		byteArrayOutputStream.write(row(row));
	    }
	    byteArrayOutputStream.write(bodyEnd());
	    byteArrayOutputStream.write(tableEnd());
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
