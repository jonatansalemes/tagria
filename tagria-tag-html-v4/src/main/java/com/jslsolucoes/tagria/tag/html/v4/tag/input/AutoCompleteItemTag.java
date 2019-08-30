package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class AutoCompleteItemTag extends AbstractSimpleTagSupport {

    private String value;
    private String text;

    @Override
    public Element render() {
	return div();
    }

    public Element div() {
	return ElementCreator.newDiv().attribute(Attribute.ID, id()).attribute(Attribute.CLASS, "autocomplete-item")
		.attribute(Attribute.DATA_VALUE, value).attribute(Attribute.DATA_TEXT, text).add(bodyContent());
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

}