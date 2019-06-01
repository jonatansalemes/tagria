
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MaskTag extends SimpleTagSupport {

	private String mask;
	private String attachTo;
	private Boolean reverse = Boolean.FALSE;
	private String onKeyPress;

	@Override
	public void doTag() throws JspException, IOException {
		TagUtil.flushBody(getJspBody());
		String placeholder = mask.replaceAll("([0-9]|[A-Za-z]|#)", "_");
		TagUtil.appendJs(
				"$('" + TagUtil.attachTo(null, attachTo, this) + "').mask('" + mask + "',{placeholder: '" + placeholder
						+ "',reverse:" + reverse + ",onKeyPress:function(value,e,field,options){" + onKeyPress + "}});",
				this);
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
}
