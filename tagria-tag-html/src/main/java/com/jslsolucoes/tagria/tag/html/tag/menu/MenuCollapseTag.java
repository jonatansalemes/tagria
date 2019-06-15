package com.jslsolucoes.tagria.tag.html.tag.menu;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class MenuCollapseTag extends AbstractSimpleTagSupport {

	private String attachTo;
	private String attachToSelector;

	@Override
	public Element render() {
		return button();
	}

	private Element button() {
		return ElementCreator.newButton().attribute(Attribute.ID, idForId(id)).attribute(Attribute.TYPE, "button")
				.attribute(Attribute.CLASS, "navbar-toggler").attribute(Attribute.DATA_TOGGLE, "collapse")
				.attribute(Attribute.ARIA_LABEL,"menu")
				.attribute(Attribute.DATA_TARGET, attachTo(attachToSelector, attachTo)).add(span());
	}

	private Element span() {
		return ElementCreator.newSpan().attribute(Attribute.CLASS, "navbar-toggler-icon");
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public String getAttachToSelector() {
		return attachToSelector;
	}

	public void setAttachToSelector(String attachToSelector) {
		this.attachToSelector = attachToSelector;
	}

}
