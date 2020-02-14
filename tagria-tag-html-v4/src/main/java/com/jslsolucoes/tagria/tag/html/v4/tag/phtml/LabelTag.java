package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.Label;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class LabelTag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;

    @Override
    public Element render() {
	return label();
    }

    private Element label() {
	Label labelElement = ElementCreator.newLabel();
	if (hasKeyOrLabel(labelKey, label)) {
	    labelElement.add(keyOrLabel(labelKey, label));
	} else {
	    labelElement.add(bodyContent());
	}

	if (!StringUtils.isEmpty(cssClass)) {
	    labelElement.attribute(Attribute.CLASS, cssClass);
	}

	return labelElement;
    }

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

}