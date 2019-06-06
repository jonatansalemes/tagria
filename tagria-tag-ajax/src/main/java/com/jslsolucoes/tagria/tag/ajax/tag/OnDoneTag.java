package com.jslsolucoes.tagria.tag.ajax.tag;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class OnDoneTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(FunctionTag.class).setOnDone(bodyContent());
	}

}
