
package com.jslsolucoes.tagria.tag.html.tag;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class MaskTag extends AbstractSimpleTagSupport {

	private String mask;
	private String attachTo;
	private String attachToSelector;
	private Boolean reverse = Boolean.FALSE;
	private String onKeyPress;

	@Override
	public void renderOnVoid() {
		String placeholder = mask.replaceAll("([0-9]|[A-Za-z]|#)", "_");
		appendJsCode("$('" + attachTo(attachToSelector, attachTo) + "').mask('" + mask + "',{placeholder: '"
				+ placeholder + "',reverse:" + reverse + ",onKeyPress:function(value,e,field,options){" + onKeyPress
				+ "}});");
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public Boolean getReverse() {
		return reverse;
	}

	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}

	public String getOnKeyPress() {
		return onKeyPress;
	}

	public void setOnKeyPress(String onKeyPress) {
		this.onKeyPress = onKeyPress;
	}

	public String getAttachToSelector() {
		return attachToSelector;
	}

	public void setAttachToSelector(String attachToSelector) {
		this.attachToSelector = attachToSelector;
	}
}
