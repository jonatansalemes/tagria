
package com.jslsolucoes.tagria.tag.ajax;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class OnErrorTag extends AbstractSimpleTagSupport {
	@Override
	public Element render() {
		findAncestorWithClass(FunctionTag.class).setOnError(bodyContent());
		return empty();
	}

}
