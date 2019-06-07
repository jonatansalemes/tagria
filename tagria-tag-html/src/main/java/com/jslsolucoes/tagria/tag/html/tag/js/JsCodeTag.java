
package com.jslsolucoes.tagria.tag.html.tag.js;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class JsCodeTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		appendJsCode(bodyContent());
	}
}
