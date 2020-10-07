
package com.jslsolucoes.tagria.exporter.v4.parser.model;

public class Column {
    private String content;
    private String align;

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String getAlign() {
	return align;
    }

    public void setAlign(String align) {
	this.align = align;
    }

    @Override
    public String toString() {
	return "Column [content=" + content + ", align=" + align + "]";
    }

}
