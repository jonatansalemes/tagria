
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class InputGroupTag extends SimpleTagSupport {
	
	private Boolean append = Boolean.FALSE;
	private Boolean prepend = Boolean.FALSE;
	
	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		div.add(Attribute.CLASS, "input-group" + (append ? "-append" : prepend ? "-prepend" : "" ));
		div.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), div);
	}

	public Boolean getAppend() {
		return append;
	}

	public void setAppend(Boolean append) {
		this.append = append;
	}

	public Boolean getPrepend() {
		return prepend;
	}

	public void setPrepend(Boolean prepend) {
		this.prepend = prepend;
	}
}
