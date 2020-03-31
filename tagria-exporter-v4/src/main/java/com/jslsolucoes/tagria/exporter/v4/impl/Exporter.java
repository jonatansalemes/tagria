package com.jslsolucoes.tagria.exporter.v4.impl;

public interface Exporter {

    public byte[] export(ExporterContext exporterContext);

    public String contentType();

    public Boolean accepts(String mediaType);
    
}
