package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class DataListOptionTag extends AbstractSimpleTagSupport {

    private String value;

    @Override
    public Element render() {
	return option();
    }

    private Element option() {
	return ElementCreator.newOption().attribute(Attribute.VALUE, value).add(bodyContent());
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

}
