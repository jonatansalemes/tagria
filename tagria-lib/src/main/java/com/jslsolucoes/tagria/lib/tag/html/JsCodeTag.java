
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class JsCodeTag extends SimpleTagSupport {

	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			TagUtil.appendJs(TagUtil.getBody(getJspBody()), this);
		}
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
}
