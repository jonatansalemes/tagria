
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CardTitleTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		out(cardTitle());
	}

	private Element cardTitle() {
		return ElementCreator.newH5().attribute(Attribute.CLASS, "card-title").add(bodyContent());
	}

}
