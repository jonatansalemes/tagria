package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class BlockTag extends SimpleTagSupport {

	private Boolean rendered = Boolean.TRUE;
	private Integer margin = 5;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Div div = new Div();
			div.add(Attribute.CLASS, "mt-"+margin+" mb-"+margin+" clearfix");
			div.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), div);
		}
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public Integer getMargin() {
		return margin;
	}

	public void setMargin(Integer margin) {
		this.margin = margin;
	}

	
}