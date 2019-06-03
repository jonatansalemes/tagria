
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CardFooterTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		out(cardFooter());
	}

	private Element cardFooter() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "card-footer").add(bodyContent());
	}

}
