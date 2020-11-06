package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class FormOnBeforeSubmitTag extends AbstractSimpleTagSupport {

    @Override
    public void renderOnVoid() {
	findAncestorWithClass(FormTag.class).setOnBeforeSubmit(bodyContent());
    }

}
