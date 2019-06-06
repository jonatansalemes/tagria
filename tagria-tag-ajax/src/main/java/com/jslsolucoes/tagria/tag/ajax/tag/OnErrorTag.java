
package com.jslsolucoes.tagria.tag.ajax.tag;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class OnErrorTag extends AbstractSimpleTagSupport {
	@Override
	public void renderOnVoid() {
		findAncestorWithClass(FunctionTag.class).setOnError(bodyContent());
	}

}
