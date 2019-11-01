package com.jslsolucoes.tagria.exporter.v4.impl;

import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public interface Exporter {

	public byte[] export(Table table);

	public String contentType();

	public Boolean accepts(String mediaType);
}
