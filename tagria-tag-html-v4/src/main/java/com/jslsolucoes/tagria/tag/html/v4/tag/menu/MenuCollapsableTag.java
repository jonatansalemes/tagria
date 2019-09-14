package com.jslsolucoes.tagria.tag.html.v4.tag.menu;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
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
