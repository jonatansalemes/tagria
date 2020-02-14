
package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.H2;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class H2Tag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;

    @Override
    public Element render() {
	return h2();
    }

    private Element h2() {
	H2 h2 = ElementCreator.newH2();
	if (hasKeyOrLabel(labelKey, label)) {
	    h2.add(keyOrLabel(labelKey, label));
	} else {
	    h2.add(bodyContent());
	}

	if (!StringUtils.isEmpty(cssClass)) {
	    h2.attribute(Attribute.CLASS, cssClass);
	}

	return h2;
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
