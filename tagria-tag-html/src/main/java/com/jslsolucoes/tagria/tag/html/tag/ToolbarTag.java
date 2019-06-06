
package com.jslsolucoes.tagria.tag.html.tag;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.html.Toolbar;

public class ToolbarTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(Toolbar.class).bodyContent(bodyContent());
	}
}
