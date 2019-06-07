package com.jslsolucoes.tagria.tag.html.tag.mask;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class MaskOnKeyPressTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(MaskTag.class).setOnKeyPress(bodyContent());
	}

}