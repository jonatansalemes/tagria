package com.jslsolucoes.tagria.tag.html.tag.tab;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class TabsTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.ID, id()).add(bodyContent());
		appendJsCode("$('#" + div.attribute(Attribute.ID) + "').tabs();");
		return div;
	}
	
}
