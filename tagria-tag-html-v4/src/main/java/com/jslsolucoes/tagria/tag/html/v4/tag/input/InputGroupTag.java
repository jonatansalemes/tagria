package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class InputGroupTag extends AbstractSimpleTagSupport {

	private Boolean append = Boolean.FALSE;
	private Boolean prepend = Boolean.FALSE;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		return ElementCreator.newDiv()
				.attribute(Attribute.CLASS, "input-group" + (append ? "-append" : prepend ? "-prepend" : ""))
				.add(bodyContent());
	}

	public Boolean getAppend() {
		return append;
	}

	public void setAppend(Boolean append) {
		this.append = append;
	}

	public Boolean getPrepend() {
		return prepend;
	}

	public void setPrepend(Boolean prepend) {
		this.prepend = prepend;
	}

}
