
package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CardTextTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		Element cardText = cardText();
		if (!StringUtils.isEmpty(cssClass)) {
			cardText.attribute(Attribute.CLASS, cssClass);
		}
		out(cardText);
	}

	private Element cardText() {
		return ElementCreator.newP().attribute(Attribute.CLASS, "card-text").add(bodyContent());
	}
}
