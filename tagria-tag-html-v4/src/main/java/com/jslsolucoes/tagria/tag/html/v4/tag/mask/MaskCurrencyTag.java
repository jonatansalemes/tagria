package com.jslsolucoes.tagria.tag.html.v4.tag.mask;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class MaskCurrencyTag extends AbstractSimpleTagSupport {

    private String attachTo;
    private String attachToSelector;

    @Override
    public void renderOnVoid() {
	appendJsCode("$('" + attachTo(attachToSelector, attachTo)
		+ "').priceFormat({prefix:'',centsSeparator:',',thousandsSeparator:'.',centsLimit:2});");
    }

    public String getAttachTo() {
	return attachTo;
    }

    public void setAttachTo(String attachTo) {
	this.attachTo = attachTo;
    }

    public String getAttachToSelector() {
	return attachToSelector;
    }

    public void setAttachToSelector(String attachToSelector) {
	this.attachToSelector = attachToSelector;
    }

}