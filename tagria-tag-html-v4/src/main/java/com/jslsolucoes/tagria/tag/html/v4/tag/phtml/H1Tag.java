package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.H1;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class H1Tag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;

    @Override
    public Element render() {
	return h1();
    }

    private Element h1() {
	H1 h1 = ElementCreator.newH1();
	if (hasKeyOrLabel(labelKey, label)) {
	    h1.add(keyOrLabel(labelKey, label));
	} else {
	    h1.add(bodyContent());
	}

	if (!StringUtils.isEmpty(cssClass)) {
	    h1.attribute(Attribute.CLASS, cssClass);
	}

	return h1;
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