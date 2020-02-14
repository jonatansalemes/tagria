
package com.jslsolucoes.tagria.tag.html.v4.tag.card;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class CardSubTitleTag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;

    @Override
    public Element render() {
	return h6();
    }

    private Element h6() {
	Element h6 = ElementCreator.newH6().attribute(Attribute.CLASS, "card-subtitle mb-2 text-muted");
	if (hasKeyOrLabel(labelKey, label)) {
	    h6.add(keyOrLabel(labelKey, label));
	} else {
	    h6.add(bodyContent());
	}
	return h6;
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
