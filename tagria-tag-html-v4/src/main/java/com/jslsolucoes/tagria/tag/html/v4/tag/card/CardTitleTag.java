
package com.jslsolucoes.tagria.tag.html.v4.tag.card;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class CardTitleTag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;

    @Override
    public Element render() {
	return h5();
    }

    private Element h5() {
	Element h5 = ElementCreator.newH5().attribute(Attribute.CLASS, "card-title");
	if (hasKeyOrLabel(labelKey, label)) {
	    h5.add(keyOrLabel(labelKey, label));
	} else {
	    h5.add(bodyContent());
	}
	
	if (!StringUtils.isEmpty(cssClass)) {
	    h5.attribute(Attribute.CLASS, cssClass);
	}
	
	return h5;
    }

    public String getLabelKey() {
	return labelKey;
    }

    public void setLabelKey(String labelKey) {
	this.labelKey = labelKey;
    }

}
