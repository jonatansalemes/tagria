package com.jslsolucoes.tagria.exporter.impl;

public interface Exporter {

	public byte[] export(String json);

	public String contentType();

	public Boolean accepts(String mediaType);
}
