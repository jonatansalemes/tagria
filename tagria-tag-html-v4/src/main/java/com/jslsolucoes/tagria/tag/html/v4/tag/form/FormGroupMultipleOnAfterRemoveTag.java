package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class FormGroupMultipleOnAfterRemoveTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(FormGroupMultipleTag.class).setOnAfterRemove(bodyContent());
	}

}
