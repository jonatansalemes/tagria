package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.H4;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class H4Tag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;

    @Override
    public Element render() {
	return h4();
    }

    private Element h4() {
	H4 h4 = ElementCreator.newH4();
	if (hasKeyOrLabel(labelKey, label)) {
	    h4.add(keyOrLabel(labelKey, label));
	} else {
	    h4.add(bodyContent());
	}

	if (!StringUtils.isEmpty(cssClass)) {
	    h4.attribute(Attribute.CLASS, cssClass);
	}

	return h4;
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