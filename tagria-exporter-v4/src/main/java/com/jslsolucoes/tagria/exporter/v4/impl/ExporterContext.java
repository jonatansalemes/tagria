package com.jslsolucoes.tagria.exporter.v4.impl;

import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class ExporterContext {

    private Table table;
    private String fileName;
    private String encoding;
    
    public ExporterContext() {
	
    }
    
    public ExporterContext(Table table, String fileName,String encoding) {
	this.table = table;
	this.fileName = fileName;
	this.encoding = encoding;
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

    public String getEncoding() {
	return encoding;
    }

    public void setEncoding(String encoding) {
	this.encoding = encoding;
    }
    
    
    
}
