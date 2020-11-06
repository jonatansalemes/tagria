package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class AutoCompleteTag extends AbstractSimpleTagSupport {
    private String url;
    private Integer delay = 1000;
    private String name;
    private Integer minLength = 3;
    private String text;
    private String textKey;
    private String placeHolder;
    private String placeHolderKey;
    private String value;
    private Boolean required = Boolean.FALSE;
    private Integer width = 400;
    private Integer height = 300;
    private String onSelect;
    private Boolean ripple = Boolean.FALSE;
    private Boolean disabled = Boolean.FALSE;

    @Override
    public Boolean flush() {
	return true;
    }

    @Override
    public Element render() {
	Element div = div();
	appendJsCode("$('#" + div.attribute(Attribute.ID) + "').autocomplete({ onSelect: function(value,text) {"
		+ onSelect + "}, url : '" + pathForUrl(url) + "',delay : " + delay + ",minLength:" + minLength
		+ ",text: '" + escapeSimpleQuote(hasKeyOrLabel(textKey, text) ? keyOrLabel(textKey, text) : "") + "'  });");
	return div;
    }

    public Element inputTextContainer() {
	Element container = ElementCreator.newDiv().attribute(Attribute.ID, id())
		.attribute(Attribute.CLASS, "form-control-container flex-fill").add(input());
	
	if (ripple) {
	    container.add(ripple());
	}

	if (required) {
	    container.attribute(Attribute.CLASS, "form-control-container-required");
	}
	
	if (ripple && disabled) {
	    container.attribute(Attribute.CLASS, "disabled-line-ripple");
	}

	appendJsCode("$('#" + container.attribute(Attribute.ID) + "').input();");
	return container;
    }

    private Element ripple() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "form-control-container-line-ripple");
    }

    private Element input() {
	Element input = ElementCreator.newInput().attribute(Attribute.TYPE, "text").attribute(Attribute.CLASS,
		"form-control autocomplete-input");
	if (required) {
	    input.attribute(Attribute.REQUIRED, "required");
	    input.attribute(Attribute.CLASS, "form-required");
	}
	
	if (disabled) {
	    input.attribute(Attribute.DISABLED, "disabled");
	    input.attribute(Attribute.CLASS, "disabled");
	}
	
	if (hasKeyOrLabel(textKey, text)) {
	    input.attribute(Attribute.VALUE, keyOrLabel(textKey, text));
	}
	if (hasKeyOrLabel(placeHolderKey, placeHolder)) {
	    input.attribute(Attribute.PLACEHOLDER, keyOrLabel(placeHolderKey, placeHolder));
	}
	return input;
    }

    private Element spinner() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "ml-2 spinner-grow text-primary autocomplete-loading")
		.attribute(Attribute.STYLE, "display:none");
    }

    private Element inputContainer() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "d-flex justify-content-between align-items-center")
		.add(inputTextContainer()).add(spinner());
    }

    private Element div() {
	return ElementCreator.newDiv().attribute(Attribute.ID, id()).attribute(Attribute.CLASS, "autocomplete")
		.add(inputContainer()).add(inputHidden()).add(results());
    }

    private Element results() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "autocomplete-results")
		.attribute(Attribute.TABINDEX, "0").attribute(Attribute.STYLE, "width:" + width + "px")
		.attribute(Attribute.STYLE, "max-height:" + height + "px");
    }

    private Element inputHidden() {
	Element inputHidden = ElementCreator.newInput().attribute(Attribute.ID, idForName(name))
		.attribute(Attribute.NAME, name).attribute(Attribute.TYPE, "hidden")
		.attribute(Attribute.CLASS, "autocomplete-input-hidden");
	if (required) {
	    inputHidden.attribute(Attribute.REQUIRED, "required");
	    inputHidden.attribute(Attribute.CLASS, "form-required");
	}
	if (!StringUtils.isEmpty(value)) {
	    inputHidden.attribute(Attribute.VALUE, value);
	}
	return inputHidden;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public Integer getDelay() {
	return delay;
    }

    public void setDelay(Integer delay) {
	this.delay = delay;
    }

    public Integer getMinLength() {
	return minLength;
    }

    public void setMinLength(Integer minLength) {
	this.minLength = minLength;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public Boolean getRequired() {
	return required;
    }

    public void setRequired(Boolean required) {
	this.required = required;
    }

    public Integer getWidth() {
	return width;
    }

    public void setWidth(Integer width) {
	this.width = width;
    }

    public String getOnSelect() {
	return onSelect;
    }

    public void setOnSelect(String onSelect) {
	this.onSelect = onSelect;
    }

    public String getTextKey() {
	return textKey;
    }

    public void setTextKey(String textKey) {
	this.textKey = textKey;
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

    public Integer getHeight() {
	return height;
    }

    public void setHeight(Integer height) {
	this.height = height;
    }

    public Boolean getRipple() {
	return ripple;
    }

    public void setRipple(Boolean ripple) {
	this.ripple = ripple;
    }

    public Boolean getDisabled() {
	return disabled;
    }

    public void setDisabled(Boolean disabled) {
	this.disabled = disabled;
    }

}