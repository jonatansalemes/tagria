
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TableLineTag extends AbstractSimpleTagSupport {

	private String state = "default";

	@Override
	public Element render() {
		return tr();
	}

	private Element tr() {
		return ElementCreator.newTr().attribute(Attribute.CLASS, "bg-" + state).add(bodyContent());
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
