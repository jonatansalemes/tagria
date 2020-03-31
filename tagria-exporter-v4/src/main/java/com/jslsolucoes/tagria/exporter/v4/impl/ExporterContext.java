package com.jslsolucoes.tagria.exporter.v4.impl;

import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class ExporterContext {

    private Table table;
    private String fileName;
    private String charset;
    
    public ExporterContext() {
	
    }
    
    public ExporterContext(Table table, String fileName, String charset) {
	this.table = table;
	this.fileName = fileName;
	this.charset = charset;
    }

    public Table getTable() {
        return table;
    }
    public void setTable(Table table) {
        this.table = table;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getCharset() {
        return charset;
    }
    public void setCharset(String charset) {
        this.charset = charset;
    }
    
    
}
