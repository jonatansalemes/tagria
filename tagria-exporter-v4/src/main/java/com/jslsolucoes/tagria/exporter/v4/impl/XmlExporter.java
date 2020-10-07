
package com.jslsolucoes.tagria.exporter.v4.impl;

import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class XmlExporter implements Exporter {

    private String headers(Table table) throws UnsupportedEncodingException {
	return "<row>" + table.getHeaders().stream().map(header -> column(header.getAlign(), header.getContent()))
		.collect(Collectors.joining()) + "</row>";
    }

    private String rows(Table table) throws UnsupportedEncodingException {
	return table.getRows().stream()
		.map(row -> "<row>" + row.getColumns().stream()
			.map(column -> column(column.getAlign(), column.getContent())).collect(Collectors.joining())
			+ "</row>")
		.collect(Collectors.joining());
    }

    private String column(String align, String content) {
	return "<column align=\"" + align + "\">" + content + "</column>";
    }

    @Override
    public byte[] export(ExporterContext exporterContext) {
	try {
	    Table table = exporterContext.getTable();
	    String encoding = exporterContext.getEncoding();
	    return ("<?xml version=\"1.0\" encoding=\"UTF-8\"?><table><title id=\"" + table.getId() + "\">"
		    + table.getTitle() + "</title><header>" + headers(table) + "</header><body>" + rows(table)
		    + "</body></table>").getBytes(encoding);
	} catch (UnsupportedEncodingException unsupportedEncodingException) {
	    throw new TagriaRuntimeException(unsupportedEncodingException);
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
