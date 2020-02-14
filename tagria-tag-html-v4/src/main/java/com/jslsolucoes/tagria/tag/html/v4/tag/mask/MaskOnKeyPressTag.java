package com.jslsolucoes.tagria.tag.html.v4.tag.mask;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class MaskOnKeyPressTag extends AbstractSimpleTagSupport {

    @Override
    public void renderOnVoid() {
	findAncestorWithClass(MaskTag.class).setOnKeyPress(bodyContent());
    }

}