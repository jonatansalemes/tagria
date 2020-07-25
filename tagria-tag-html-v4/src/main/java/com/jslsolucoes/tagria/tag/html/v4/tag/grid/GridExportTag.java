package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import java.util.UUID;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.Span;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class GridExportTag extends AbstractSimpleTagSupport {

    private Boolean pdf = Boolean.TRUE;
    private Boolean xlsx = Boolean.TRUE;
    private Boolean csv = Boolean.TRUE;
    private Boolean xml = Boolean.TRUE;
    private String filename = UUID.randomUUID().toString();
    private String filenameKey;
    private Boolean timestamp = Boolean.TRUE;
    private String pattern = "dd/MM/yyyy HH:mm:ss";

    @Override
    public void renderOnVoid() {
	String dataParent = findAncestorWithClass(GridTag.class).getId();
	findAncestorWithClass(GridTag.class).setExport(divExport(dataParent));
    }

    private Element divExport(String dataParent) {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "m-3").add(formExport(dataParent))
		.add(divButtonGroup(dataParent));
    }

    private Element formExport(String dataParent) {
	return ElementCreator.newForm().attribute(Attribute.DATA_PARENT, dataParent).attribute(Attribute.METHOD, "post")
		.attribute(Attribute.TARGET, "_blank").attribute(Attribute.CLASS, "grid-export-form hidden")
		.attribute(Attribute.ACTION, pathForUrl("/tagria-exporter/v4")).add(inputType(dataParent))
		.add(inputJson(dataParent)).add(inputFileName()).add(inputTimestamp()).add(inputPattern());
    }

    private Element inputTimestamp() {
	return ElementCreator.newInput().attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "timestamp")
		.attribute(Attribute.VALUE, timestamp);
    }

    private Element inputPattern() {
	return ElementCreator.newInput().attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "pattern")
		.attribute(Attribute.VALUE, pattern);
    }

    private Element inputFileName() {
	return ElementCreator.newInput().attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "filename")
		.attribute(Attribute.VALUE, keyOrLabel(filenameKey, filename));
    }

    private Element inputType(String dataParent) {
	return ElementCreator.newInput().attribute(Attribute.DATA_PARENT, dataParent)
		.attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "type")
		.attribute(Attribute.CLASS, "grid-export-type");
    }

    private Element inputJson(String dataParent) {
	return ElementCreator.newInput().attribute(Attribute.DATA_PARENT, dataParent)
		.attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "json")
		.attribute(Attribute.CLASS, "grid-export-json");
    }

    private Element divButtonGroup(String dataParent) {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "btn-group");
	if (pdf) {
	    div.add(buttonPDF(dataParent));
	}
	if (xlsx) {
	    div.add(buttonXlsx(dataParent));
	}
	if (csv) {
	    div.add(buttonCsv(dataParent));
	}
	if (xml) {
	    div.add(buttonXml(dataParent));
	}
	return div;
    }

    private Element buttonXml(String dataParent) {
	return ElementCreator.newButton().attribute(Attribute.DATA_PARENT, dataParent)
		.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-xml ")
		.attribute(Attribute.TITLE, keyForLibrary("grid.export.xml"))
		.add(new Span().attribute(Attribute.CLASS, "fa fa-file-code"));
    }

    private Element buttonCsv(String dataParent) {
	return ElementCreator.newButton().attribute(Attribute.DATA_PARENT, dataParent)
		.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-csv ")
		.attribute(Attribute.TITLE, keyForLibrary("grid.export.csv"))
		.add(new Span().attribute(Attribute.CLASS, "fa fa-file-csv"));
    }

    private Element buttonXlsx(String dataParent) {
	return ElementCreator.newButton().attribute(Attribute.DATA_PARENT, dataParent)
		.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-excel ")
		.attribute(Attribute.TITLE, keyForLibrary("grid.export.xls"))
		.add(new Span().attribute(Attribute.CLASS, "fa fa-file-excel"));
    }

    private Element buttonPDF(String dataParent) {
	return ElementCreator.newButton().attribute(Attribute.DATA_PARENT, dataParent)
		.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-pdf ")
		.attribute(Attribute.TITLE, keyForLibrary("grid.export.pdf"))
		.add(new Span().attribute(Attribute.CLASS, "fa fa-file-pdf"));
    }

    public Boolean getPdf() {
	return pdf;
    }

    public void setPdf(Boolean pdf) {
	this.pdf = pdf;
    }

    public Boolean getCsv() {
	return csv;
    }

    public void setCsv(Boolean csv) {
	this.csv = csv;
    }

    public Boolean getXml() {
	return xml;
    }

    public void setXml(Boolean xml) {
	this.xml = xml;
    }

    public Boolean getXlsx() {
	return xlsx;
    }

    public void setXlsx(Boolean xlsx) {
	this.xlsx = xlsx;
    }

    public String getFilename() {
	return filename;
    }

    public void setFilename(String filename) {
	this.filename = filename;
    }

    public Boolean getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(Boolean timestamp) {
	this.timestamp = timestamp;
    }

    public String getPattern() {
	return pattern;
    }

    public void setPattern(String pattern) {
	this.pattern = pattern;
    }

    public String getFilenameKey() {
	return filenameKey;
    }

    public void setFilenameKey(String filenameKey) {
	this.filenameKey = filenameKey;
    }

}
