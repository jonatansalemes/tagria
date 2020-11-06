package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.html.v4.tag.ViewTag;

public class TemplateParameterTag extends AbstractSimpleTagSupport {

    private String name;
    private String value;

    @Override
    public void renderOnVoid() {
	findAncestorWithClass(ViewTag.class).withTemplateParam(name, value);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

}
