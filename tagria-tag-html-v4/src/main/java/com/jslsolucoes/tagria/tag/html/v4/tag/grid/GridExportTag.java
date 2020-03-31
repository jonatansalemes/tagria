package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

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
    private String fileName = "data";

    @Override
    public void renderOnVoid() {
	findAncestorWithClass(GridTag.class).setExport(divExport());
    }

    private Element divExport() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "m-3").add(formExport()).add(divButtonGroup());
    }

    private Element formExport() {
	return ElementCreator.newForm().attribute(Attribute.METHOD, "post").attribute(Attribute.TARGET, "_blank")
		.attribute(Attribute.CLASS, "grid-export-form hidden")
		.attribute(Attribute.ACTION, pathForUrl("/tagria-exporter/v4")).add(inputType()).add(inputJson())
		.add(inputFileName());
    }

    private Element inputFileName() {
	return ElementCreator.newInput().attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "fileName")
		.attribute(Attribute.VALUE, fileName);
    }

    private Element inputType() {
	return ElementCreator.newInput().attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "type")
		.attribute(Attribute.CLASS, "grid-export-type");
    }

    private Element inputJson() {
	return ElementCreator.newInput().attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "json")
		.attribute(Attribute.CLASS, "grid-export-json");
    }

    private Element divButtonGroup() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "btn-group");
	if (pdf) {
	    div.add(buttonPDF());
	}
	if (xlsx) {
	    div.add(buttonXlsx());
	}
	if (csv) {
	    div.add(buttonCsv());
	}
	if (xml) {
	    div.add(buttonXml());
	}
	return div;
    }

    private Element buttonXml() {
	return ElementCreator.newButton().attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-xml ")
		.attribute(Attribute.TITLE, keyForLibrary("grid.export.xml"))
		.add(new Span().attribute(Attribute.CLASS, "fa fa-file-code"));
    }

    private Element buttonCsv() {
	return ElementCreator.newButton().attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-csv ")
		.attribute(Attribute.TITLE, keyForLibrary("grid.export.csv"))
		.add(new Span().attribute(Attribute.CLASS, "fa fa-file-csv"));
    }

    private Element buttonXlsx() {
	return ElementCreator.newButton().attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-excel ")
		.attribute(Attribute.TITLE, keyForLibrary("grid.export.xls"))
		.add(new Span().attribute(Attribute.CLASS, "fa fa-file-excel"));
    }

    private Element buttonPDF() {
	return ElementCreator.newButton().attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-pdf ")
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

    public String getFileName() {
	return fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }

}
