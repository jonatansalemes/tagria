
package com.jslsolucoes.tagria.tag.html.tag;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class FormToolbarTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(FormTag.class).setToolbar(toolbar());
	}

	private Element toolbar() {
		return ElementCreator.newCData(bodyContent());
	}
}
