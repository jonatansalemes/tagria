
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class CollapsableTag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;
    private Boolean opened = Boolean.FALSE;

    @Override
    public Element render() {
	return div(id());
    }

    private Element divContent(String id) {
	return ElementCreator.newDiv().attribute(Attribute.ID, id)
		.attribute(Attribute.CLASS, "collapse " + (opened ? "show" : "")).add(divBody());
    }

    private Element divBody() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "card-body").add(bodyContent());
    }

    private Element button(String id) {
	return ElementCreator.newButton().attribute(Attribute.CLASS, "btn btn-link")
		.attribute(Attribute.DATA_TOGGLE, "collapse").attribute(Attribute.DATA_TARGET, "#" + id)
		.attribute(Attribute.ID, id()).add(keyOrLabel(labelKey, label));
    }

    private Element h5Header(String id) {
	return ElementCreator.newH5().attribute(Attribute.CLASS, "mb-0").add(button(id));
    }

    private Element divHeader(String id) {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "card-header").add(h5Header(id));
    }

    private Element div(String id) {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "card").attribute(Attribute.ID, id())
		.add(divHeader(id)).add(divContent(id));
	if (!StringUtils.isEmpty(cssClass)) {
	    div.attribute(Attribute.CLASS, cssClass);
	}
	return div;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public Boolean getOpened() {
	return opened;
    }

    public void setOpened(Boolean opened) {
	this.opened = opened;
    }

    public String getLabelKey() {
	return labelKey;
    }

    public void setLabelKey(String labelKey) {
	this.labelKey = labelKey;
    }

}