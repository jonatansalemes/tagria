
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Tr;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableLineTag extends SimpleTagSupport {

	private String state = "default";
	private Boolean rendered = true;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Tr tr = new Tr();
			tr.add(Attribute.CLASS, "bg-" + state);
			tr.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), tr);
		}
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
