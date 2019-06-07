package com.jslsolucoes.tagria.tag.html.tag.mask;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class CurrencyMaskTag extends AbstractSimpleTagSupport {

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