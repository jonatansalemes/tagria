package com.jslsolucoes.tagria.tag.html.v4.tag.dropdown;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class DropDownTag extends AbstractSimpleTagSupport {

    private String id;
    private String label;
    private String labelKey;
    private String state = "primary";
    private String size;
    private String direction = "down";

    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "drop" + direction).add(button())
		.add(divDropDown());
	if (!StringUtils.isEmpty(cssClass)) {
	    div.attribute(Attribute.CLASS, cssClass);
	}
	return div;

    }

    private Element divDropDown() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "dropdown-menu").add(bodyContent());
    }

    private Element button() {
	Element button = ElementCreator.newButton().attribute(Attribute.TYPE, "button")
		.attribute(Attribute.ID, idForId(id))
		.attribute(Attribute.CLASS, "btn btn-outline-" + state + " shadow-xl dropdown-toggle")
		.attribute(Attribute.DATA_TOGGLE, "dropdown").add(keyOrLabel(labelKey, label));
	if (!StringUtils.isEmpty(size)) {
	    button.attribute(Attribute.CLASS, "btn-" + size);
	}
	return button;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public Boolean getRendered() {
	return rendered;
    }

    public void setRendered(Boolean rendered) {
	this.rendered = rendered;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getSize() {
	return size;
    }

    public void setSize(String size) {
	this.size = size;
    }

    public String getLabelKey() {
	return labelKey;
    }

    public void setLabelKey(String labelKey) {
	this.labelKey = labelKey;
    }

    public String getDirection() {
	return direction;
    }

    public void setDirection(String direction) {
	this.direction = direction;
    }
}