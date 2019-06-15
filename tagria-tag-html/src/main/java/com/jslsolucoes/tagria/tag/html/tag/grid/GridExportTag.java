package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Form;
import com.jslsolucoes.tagria.html.Input;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridExportTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		Div divForExportation = new Div();
		divForExportation.attribute(Attribute.CLASS, "float-right m-3");

		Div buttonGroup = new Div();
		buttonGroup.attribute(Attribute.CLASS, "btn-group");

		Button pdf = new Button();
		pdf.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-pdf");
		pdf.attribute(Attribute.TITLE, keyForLibrary("grid.export.pdf"));
		pdf.add(new Span().attribute(Attribute.CLASS, "fa fa-file-pdf"));
		buttonGroup.add(pdf);

		Button excel = new Button();
		excel.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-excel");
		excel.attribute(Attribute.TITLE, keyForLibrary("grid.export.xls"));
		excel.add(new Span().attribute(Attribute.CLASS, "fa fa-file-excel"));
		buttonGroup.add(excel);

		Button csv = new Button();
		csv.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-csv");
		csv.attribute(Attribute.TITLE, keyForLibrary("grid.export.csv"));
		csv.add(new Span().attribute(Attribute.CLASS, "fa fa-file-csv"));
		buttonGroup.add(csv);

		Button xml = new Button();
		xml.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-xml");
		xml.attribute(Attribute.TITLE, keyForLibrary("grid.export.xml"));
		xml.add(new Span().attribute(Attribute.CLASS, "fa fa-file-code"));
		buttonGroup.add(xml);

		divForExportation.add(buttonGroup);
		
		Div exporter = new Div();
		exporter.attribute(Attribute.CLASS, "hidden");
		Form form = new Form();
		form.attribute(Attribute.METHOD, "post");
		form.attribute(Attribute.TARGET, "_blank");
		form.attribute(Attribute.CLASS, "grid-export-form");
		form.attribute(Attribute.ACTION, pathForUrl("/tagria-exporter"));
		Input type = new Input();
		type.attribute(Attribute.TYPE, "hidden");
		type.attribute(Attribute.NAME, "type");
		type.attribute(Attribute.CLASS, "grid-export-type");
		form.add(type);
		Input html = new Input();
		html.attribute(Attribute.TYPE, "hidden");
		html.attribute(Attribute.NAME, "json");
		html.attribute(Attribute.CLASS, "grid-export-json");
		form.add(html);
		divForExportation.add(form);
		
		findAncestorWithClass(GridTag.class).setExport(divForExportation);
	}
	
}
