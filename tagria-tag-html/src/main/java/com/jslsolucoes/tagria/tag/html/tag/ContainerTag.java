
package com.jslsolucoes.tagria.tag.html.tag;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class ContainerTag extends AbstractSimpleTagSupport {

	private Boolean fluid = Boolean.FALSE;

	@Override
	public Element render() {
		return container();
	}

	private Element container() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "container" + (fluid ? "-fluid" : ""))
				.add(bodyContent());
	}

	public Boolean getFluid() {
		return fluid;
	}

	public void setFluid(Boolean fluid) {
		this.fluid = fluid;
	}
}
