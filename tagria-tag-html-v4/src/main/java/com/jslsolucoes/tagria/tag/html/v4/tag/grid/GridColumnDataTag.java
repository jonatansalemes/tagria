package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.Span;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class GridColumnDataTag extends AbstractSimpleTagSupport {

    private String align = "left";
    private String state;
    private Boolean exportable = Boolean.FALSE;
    private Boolean collapsable = Boolean.FALSE;
    private String formatter;

    @Override
    public Element render() {
	return td();
    }

    private Element td() {
	Element td = ElementCreator.newTd().attribute(Attribute.CLASS, "text-" + (collapsable ? "center" : align));

	if (!StringUtils.isEmpty(state)) {
	    td.attribute(Attribute.CLASS, "bg-" + state);
	}

	if (exportable) {
	    td.attribute(Attribute.CLASS, "grid-column-exportable");
	}

	if (!StringUtils.isEmpty(cssClass)) {
	    td.attribute(Attribute.CLASS, cssClass);
	}

	if (collapsable) {
	    String id = id();
	    td.add(button(id));
	    td.add(divModal(id));
	} else {
	    td.add(divContent());
	}
	return td;
    }

    private Element button(String id) {
	return ElementCreator.newButton()
		.attribute(Attribute.DATA_TOGGLE, "modal")
		.attribute(Attribute.DATA_TARGET, "#"+id)
		.attribute(Attribute.CLASS, "btn btn-outline-dark shadow-xl")
		.add(new Span().attribute(Attribute.CLASS, "fa fa-search"));
    }

    private Element divContent() {
	return ElementCreator.newDiv().add(format(formatter, bodyContent()));
    }
    
    public Element divModal(String id) {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal fade").attribute(Attribute.ID, id)
			.add(divModalDialog());
    }
    
    private Element divModalDialog() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-dialog modal-dialog-centered")
			.add(divModalContent());
    }
    
    private Element divModalContent() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-content").add(divModalHeader())
			.add(divModalBody());
    }
    
    private Element divModalHeader() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-header").add(h4()).add(button());
    }
    
    private Element divModalBody() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-body").add(divContent());
    }
    
    private Element button() {
	return ElementCreator.newButton().attribute(Attribute.CLASS, "close").attribute(Attribute.DATA_DISMISS, "modal")
			.add(spanTimes());
    }
    
    private Element spanTimes() {
    	return ElementCreator.newSpan().add("&times;");
    }
    
    private Element h4() {
    	return ElementCreator.newH4().attribute(Attribute.CLASS, "modal-title")
    			.add(keyForLibrary("grid.collapsable.show"));
    }

    public String getAlign() {
	return align;
    }

    public void setAlign(String align) {
	this.align = align;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public Boolean getExportable() {
	return exportable;
    }

    public void setExportable(Boolean exportable) {
	this.exportable = exportable;
    }

    public Boolean getCollapsable() {
	return collapsable;
    }

    public void setCollapsable(Boolean collapsable) {
	this.collapsable = collapsable;
    }

    public String getFormatter() {
	return formatter;
    }

    public void setFormatter(String formatter) {
	this.formatter = formatter;
    }
}
