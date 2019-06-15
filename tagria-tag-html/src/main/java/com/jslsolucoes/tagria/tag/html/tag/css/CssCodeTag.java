
package com.jslsolucoes.tagria.tag.html.tag.css;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class CssCodeTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		appendCssCode(bodyContent());
	}
}
