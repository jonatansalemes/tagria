
package com.jslsolucoes.tagria.tag.html.v4.tag.card;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class CardTag extends AbstractSimpleTagSupport {

    private String state = "default";
    private Boolean visible = Boolean.TRUE;

    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	Element div = ElementCreator.newDiv().attribute(Attribute.ID, idForId(id))
		.attribute(Attribute.CLASS, "card  bg-" + state).add(bodyContent());
	if (!StringUtils.isEmpty(cssClass)) {
	    div.attribute(Attribute.CLASS, cssClass);
	}
	if (!visible) {
	    div.attribute(Attribute.CLASS, "d-none");
	}
	return div;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public Boolean getVisible() {
	return visible;
    }

    public void setVisible(Boolean visible) {
	this.visible = visible;
    }

}
