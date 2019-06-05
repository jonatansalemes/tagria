package com.jslsolucoes.tagria.tag.ajax;

import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class BeforeSendTag extends AbstractSimpleTagSupport {

	@Override
	public void bypass() {
		findAncestorWithClass(FunctionTag.class).setBeforeSend(bodyContent());
	}

}
