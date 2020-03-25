package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class SpanTag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;

    @Override
    public Element render() {
	return span();
    }

    private Element span() {
	Element span = ElementCreator.newSpan().attribute(Attribute.ID, idForId(id));
	if (hasKeyOrLabel(labelKey, label)) {
	    span.add(keyOrLabel(labelKey, label));
	} else {
	    span.add(bodyContent());
	}

	if (!StringUtils.isEmpty(cssClass)) {
	    span.attribute(Attribute.CLASS, cssClass);
	}

	return span;
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