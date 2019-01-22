
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ContainerTag extends SimpleTagSupport {

	private Boolean fluid = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		div.add(Attribute.CLASS, "container" + (fluid ? "-fluid" : ""));
		div.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), div);
	}

	public Boolean getFluid() {
		return fluid;
	}

	public void setFluid(Boolean fluid) {
		this.fluid = fluid;
	}
}
