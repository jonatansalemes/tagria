
package com.jslsolucoes.tagria.tag.html.tag.card;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class CardTitleTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		return ElementCreator.newH5().attribute(Attribute.CLASS, "card-title").add(bodyContent());
	}

}
