package com.jslsolucoes.tagria.tag.html.v4.tag.tab;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class TabsHeaderTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return ul();
	}

	private Element ul() {
		return ElementCreator.newUl().attribute(Attribute.CLASS, "nav nav-tabs").add(bodyContent());
	}

}
