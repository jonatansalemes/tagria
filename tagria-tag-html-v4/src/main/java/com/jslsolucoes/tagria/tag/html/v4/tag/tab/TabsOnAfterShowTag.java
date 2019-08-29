package com.jslsolucoes.tagria.tag.html.v4.tag.tab;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class TabsOnAfterShowTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(TabsTag.class).setOnAfterShow(bodyContent());
	}

}
