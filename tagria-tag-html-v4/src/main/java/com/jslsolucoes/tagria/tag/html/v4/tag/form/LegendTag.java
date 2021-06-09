package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class LegendTag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public String getLabelKey() {
	return labelKey;
    }

    public void setLabelKey(String labelKey) {
	this.labelKey = labelKey;
    }

    @Override
    public Element render() {
	return legend();
    }

    private Element legend() {
	Element fieldset = ElementCreator.newLegend();
	if (hasKeyOrLabel(labelKey, label)) {
	    fieldset.add(keyOrLabel(labelKey, label));
	} else {
	    fieldset.add(bodyContent());
	}
	return fieldset;
    }

}
