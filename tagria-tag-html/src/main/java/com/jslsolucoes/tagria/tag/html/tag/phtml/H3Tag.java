package com.jslsolucoes.tagria.tag.html.tag.phtml;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class H3Tag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return h3();
	}

	private Element h3() {
		return ElementCreator.newH3().add(bodyContent());
	}

}