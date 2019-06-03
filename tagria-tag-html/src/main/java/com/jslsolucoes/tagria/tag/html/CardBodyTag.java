
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CardBodyTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		out(cardBody());
	}

	private Element cardBody() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "card-body").add(bodyContent());
	}

}
