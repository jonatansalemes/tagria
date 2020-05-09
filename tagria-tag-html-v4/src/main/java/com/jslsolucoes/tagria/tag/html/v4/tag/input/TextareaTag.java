
package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class TextareaTag extends AbstractSimpleTagSupport {

    private String name;
    private String value;
    private String placeHolder;
    private String placeHolderKey;
    private Boolean required = Boolean.FALSE;
    private Integer rows = 4;
    private Boolean disabled = Boolean.FALSE;
    private Boolean ripple = Boolean.FALSE;
    private Integer maxLength;
    private Boolean maxLengthCount = Boolean.FALSE;

    @Override
    public Element render() {
	return inputTextContainer();
    }

    public Element inputTextContainer() {
	Element container = ElementCreator.newDiv().attribute(Attribute.ID, id())
		.attribute(Attribute.CLASS, "form-control-container").add(textarea());

	if (ripple) {
	    container.add(ripple());
	}

	if (required) {
	    container.attribute(Attribute.CLASS, "form-control-container-required");
	}

	if (ripple && disabled) {
	    container.attribute(Attribute.CLASS, "disabled-line-ripple");
	}

	Element toolbar = toolbar();
	if (maxLength != null && maxLengthCount) {
	    toolbar.add(maxLengthCounter());
	}
	container.add(toolbar);

	appendJsCode("$('#" + container.attribute(Attribute.ID) + "').textarea({ maxLength : "+maxLength+",maxLengthCount : "+maxLengthCount+"  });");
	return container;
    }

    private Element maxLengthCounter() {
	return ElementCreator.newSpan().attribute(Attribute.CLASS, "maxlenght-counter")
		.add((StringUtils.isEmpty(value) ? "0" : value.length()) + "/" + maxLength);
    }

    private Element toolbar() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS,
		"d-flex justify-content-end align-items-center form-control-container-toolbar");
    }

    private Element ripple() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "form-control-container-line-ripple");
    }

    private Element textarea() {
	Element textArea = ElementCreator.newTextArea().attribute(Attribute.NAME, name).attribute(Attribute.ROWS, rows)
		.attribute(Attribute.ARIA_LABEL, "textarea").attribute(Attribute.ID, idForName(name))
		.attribute(Attribute.CLASS, "form-control ");
	if (!StringUtils.isEmpty(cssClass)) {
	    textArea.attribute(Attribute.CLASS, cssClass);
	}
	
	if (maxLength != null) {
	    textArea.attribute(Attribute.DATA_MAXLENGTH, maxLength);
	}

	if (hasKeyOrLabel(placeHolderKey, placeHolder)) {
	    textArea.attribute(Attribute.PLACEHOLDER, keyOrLabel(placeHolderKey, placeHolder));
	}

	String textAreaValue = !StringUtils.isEmpty(value) ? value : bodyContent();

	if (!StringUtils.isEmpty(textAreaValue)) {
	    if (maxLength != null && textAreaValue.length() > maxLength) {
		textAreaValue = textAreaValue.substring(0, maxLength);
	    }
	    textArea.add(textAreaValue);
	}

	if (required) {
	    textArea.attribute(Attribute.REQUIRED, "required");
	    if (StringUtils.isEmpty(placeHolder) && StringUtils.isEmpty(placeHolderKey)
		    && StringUtils.isEmpty(textAreaValue)) {
		textArea.attribute(Attribute.PLACEHOLDER, keyForLibrary("textarea.required.placeholder"));
	    }
	}

	return textArea;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Boolean getRequired() {
	return required;
    }

    public void setRequired(Boolean required) {
	this.required = required;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }

    public Integer getRows() {
	return rows;
    }

    public void setRows(Integer rows) {
	this.rows = rows;
    }

    public String getPlaceHolder() {
	return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
	this.placeHolder = placeHolder;
    }

    public String getPlaceHolderKey() {
	return placeHolderKey;
    }

    public void setPlaceHolderKey(String placeHolderKey) {
	this.placeHolderKey = placeHolderKey;
    }

    public Boolean getDisabled() {
	return disabled;
    }

    public void setDisabled(Boolean disabled) {
	this.disabled = disabled;
    }

    public Boolean getRipple() {
	return ripple;
    }

    public void setRipple(Boolean ripple) {
	this.ripple = ripple;
    }

    public Integer getMaxLength() {
	return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
	this.maxLength = maxLength;
    }

    public Boolean getMaxLengthCount() {
	return maxLengthCount;
    }

    public void setMaxLengthCount(Boolean maxLengthCount) {
	this.maxLengthCount = maxLengthCount;
    }

}
