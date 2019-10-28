
package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class FormToolbarTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "mt-3 mb-3").add(bodyContent());
	}
}