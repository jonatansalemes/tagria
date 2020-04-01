
package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class FormGroupTag extends AbstractSimpleTagSupport {

    private String forElement;
    private String label;
    private String labelKey;
    private Boolean required = Boolean.FALSE;
    private Boolean visible = Boolean.TRUE;

    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "form-group d-flex flex-column-reverse border rounded p-1").attribute(Attribute.ID,
		idForId(id));
	if (!visible) {
	    div.attribute(Attribute.CLASS, "collapse");
	}
	div.add(bodyContent());
	if (hasKeyOrLabel(labelKey, label)) {
	    div.add(label());
	}
	return div;
    }
    
    private Element label() {
	String label = keyOrLabel(labelKey, this.label);
	Element element = ElementCreator.newLabel().attribute(Attribute.TITLE, label).attribute(Attribute.CLASS,"text-truncate");
	if (required) {
	    element.add(span());
	}
	element.add(label);
	if (!StringUtils.isEmpty(forElement)) {
	    element.attribute(Attribute.FOR, idForName(forElement));
	}
	return element;
    }

    private Element span() {
	return ElementCreator.newSpan().attribute(Attribute.CLASS, "text-danger").add(" * ");
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public Boolean getRequired() {
	return required;
    }

    public void setRequired(Boolean required) {
	this.required = required;
    }

    public String getForElement() {
	return forElement;
    }

    public void setForElement(String forElement) {
	this.forElement = forElement;
    }

    public Boolean getRendered() {
	return rendered;
    }

    public void setRendered(Boolean rendered) {
	this.rendered = rendered;
    }

    public Boolean getVisible() {
	return visible;
    }

    public void setVisible(Boolean visible) {
	this.visible = visible;
    }

    public String getLabelKey() {
	return labelKey;
    }

    public void setLabelKey(String labelKey) {
	this.labelKey = labelKey;
    }
}
