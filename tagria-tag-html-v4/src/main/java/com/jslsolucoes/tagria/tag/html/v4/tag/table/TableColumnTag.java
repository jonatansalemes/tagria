
package com.jslsolucoes.tagria.tag.html.v4.tag.table;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class TableColumnTag extends AbstractSimpleTagSupport {

    private String state = "default";
    private Integer colspan;
    private String label;
    private String labelKey;

    @Override
    public Element render() {
	return td();
    }

    private Element td() {

	Element td = ElementCreator.newTd().attribute(Attribute.CLASS, "bg-" + state);
	if (colspan != null) {
	    td.attribute(Attribute.COLSPAN, colspan);
	}
	if (hasKeyOrLabel(labelKey, label)) {
	    td.add(keyOrLabel(labelKey, label));
	} else {
	    td.add(bodyContent());
	}
	return td;
    }

    public Integer getColspan() {
	return colspan;
    }

    public void setColspan(Integer colspan) {
	this.colspan = colspan;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getLabelKey() {
	return labelKey;
    }

    public void setLabelKey(String labelKey) {
	this.labelKey = labelKey;
    }

}
