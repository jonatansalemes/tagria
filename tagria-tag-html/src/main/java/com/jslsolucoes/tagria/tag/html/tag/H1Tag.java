package com.jslsolucoes.tagria.tag.html.tag;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class H1Tag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return h1();
	}

	private Element h1() {
		return ElementCreator.newH1().add(bodyContent());
	}

}