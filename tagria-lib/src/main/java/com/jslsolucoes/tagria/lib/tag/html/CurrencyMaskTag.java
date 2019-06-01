package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CurrencyMaskTag extends SimpleTagSupport {

	private String attachTo;
	private String attachToSelector;

	@Override
	public void doTag() throws JspException, IOException {

		TagUtil.appendJs("$('" + TagUtil.attachTo(attachToSelector, attachTo, this)
				+ "').priceFormat({prefix:'',centsSeparator:',',thousandsSeparator:'.',centsLimit:2});", this);

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