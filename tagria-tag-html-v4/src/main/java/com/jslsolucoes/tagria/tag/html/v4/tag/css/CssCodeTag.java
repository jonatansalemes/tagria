
package com.jslsolucoes.tagria.tag.html.v4.tag.css;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class CssCodeTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		appendCssCode(bodyContent());
	}
}
