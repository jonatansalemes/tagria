
package com.jslsolucoes.tagria.tag.html.tag.img;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class IconTag extends AbstractSimpleTagSupport {

	private String icon;

	@Override
	public Element render() {
		return span();
	}

	private Element span() {
		return ElementCreator.newSpan().attribute(Attribute.ID, idForId(id)).attribute(Attribute.CLASS,
				"fas fa-" + icon);
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
