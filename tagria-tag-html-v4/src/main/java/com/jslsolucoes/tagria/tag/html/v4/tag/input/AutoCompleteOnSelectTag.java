package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class AutoCompleteOnSelectTag extends AbstractSimpleTagSupport {

    @Override
    public void renderOnVoid() {
	findAncestorWithClass(AutoCompleteTag.class).setOnSelect(bodyContent());
    }

}