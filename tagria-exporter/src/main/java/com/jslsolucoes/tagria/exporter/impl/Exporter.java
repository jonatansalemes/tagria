package com.jslsolucoes.tagria.exporter.impl;

import com.jslsolucoes.tagria.exporter.parser.model.Table;

public interface Exporter {

	public byte[] export(Table table);

	public String contentType();

	public Boolean accepts(String mediaType);
}
