
package com.jslsolucoes.tagria.tag.ajax.tag;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class OnSuccessTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(FunctionTag.class).addOnSuccess(bodyContent());
	}
	
	@Override
	public Boolean flush() {
		return true;
	}
}
