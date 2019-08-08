
package com.jslsolucoes.tagria.tag.html.v4.tag.img;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
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
