package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class MaskTagOnKeyPress extends AbstractSimpleTagSupport {

	@Override
	public void bypass() {
		findAncestorWithClass(MaskTag.class).setOnKeyPress(bodyContent());
	}

}