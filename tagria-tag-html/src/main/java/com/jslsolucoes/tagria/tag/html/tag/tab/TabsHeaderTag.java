package com.jslsolucoes.tagria.tag.html.tag.tab;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class TabsHeaderTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return ul();
	}

	private Element ul() {
		return ElementCreator.newUl().attribute(Attribute.CLASS, "nav nav-tabs").add(bodyContent());
	}

}
