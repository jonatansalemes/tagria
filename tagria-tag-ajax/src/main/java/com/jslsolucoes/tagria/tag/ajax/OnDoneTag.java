package com.jslsolucoes.tagria.tag.ajax;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class OnDoneTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		findAncestorWithClass(FunctionTag.class).setOnDone(bodyContent());
		return empty();
	}

}
