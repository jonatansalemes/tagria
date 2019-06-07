package com.jslsolucoes.tagria.tag.html.tag.menu;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class MenuCollapsableTag extends AbstractSimpleTagSupport {

	private String id;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		return ElementCreator.newDiv().attribute(Attribute.ID, idForId(id))
				.attribute(Attribute.CLASS, "collapse navbar-collapse").add(ul());
	}

	private Element ul() {
		return ElementCreator.newUl().attribute(Attribute.CLASS, "navbar-nav mr-auto").add(bodyContent());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
