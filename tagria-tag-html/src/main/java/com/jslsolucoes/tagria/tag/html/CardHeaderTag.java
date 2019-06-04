
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CardHeaderTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		out(cardHeader());
	}
	
	private Element cardHeader() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "card-header").add(bodyContent());
	}

}
