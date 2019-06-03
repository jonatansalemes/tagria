
package com.jslsolucoes.tagria.tag.ajax;

import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class OnErrorTag extends AbstractSimpleTagSupport {
	@Override
	public void render() {
		FunctionTag functionTag = findAncestorWithClass(FunctionTag.class);
		functionTag.setOnError(bodyContent());
	}

}
