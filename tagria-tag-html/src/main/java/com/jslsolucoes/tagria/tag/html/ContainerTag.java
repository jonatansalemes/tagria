
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class ContainerTag extends AbstractSimpleTagSupport {

	private Boolean fluid = Boolean.FALSE;

	@Override
	public void render() {
		Div div = new Div();
		div.attribute(Attribute.CLASS, "container" + (fluid ? "-fluid" : ""));
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
