package com.jslsolucoes.tagria.exporter.v4.impl;

import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class ExporterContext {

    private Table table;
    private String filename;
    private String encoding;
    
    public ExporterContext() {
	
    }
    
    public ExporterContext(Table table, String filename,String encoding) {
	this.table = table;
	this.filename = filename;
	this.encoding = encoding;
    }

    public Table getTable() {
        return table;
    }
    public void setTable(Table table) {
        this.table = table;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getEncoding() {
	return encoding;
    }

    public void setEncoding(String encoding) {
	this.encoding = encoding;
    }
    
    
    
}
