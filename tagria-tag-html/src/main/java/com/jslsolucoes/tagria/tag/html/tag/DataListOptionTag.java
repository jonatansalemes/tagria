package com.jslsolucoes.tagria.tag.html.tag;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

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
