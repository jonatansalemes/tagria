package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class H1Tag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return h1();
	}

	private Element h1() {
		return ElementCreator.newH1().add(bodyContent());
	}

}