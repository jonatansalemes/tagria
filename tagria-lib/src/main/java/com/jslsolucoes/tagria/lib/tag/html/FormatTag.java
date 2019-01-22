
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class FormatTag extends SimpleTagSupport {

	private String type;

	@Override
	public void doTag() throws JspException, IOException {
		TagUtil.out(getJspContext(), TagUtil.format(type, TagUtil.getBody(getJspBody()), getJspContext()));
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
