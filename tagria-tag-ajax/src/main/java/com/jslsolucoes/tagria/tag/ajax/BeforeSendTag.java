package com.jslsolucoes.tagria.tag.ajax;

import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class BeforeSendTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(FunctionTag.class).setBeforeSend(bodyContent());
	}

}
