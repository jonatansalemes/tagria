
package com.jslsolucoes.tagria.tag.html.v4.tag.layout;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class ContainerTag extends AbstractSimpleTagSupport {

    private Boolean fluid = Boolean.FALSE;

    @Override
    public Element render() {
	return container();
    }

    private Element container() {
	Element div =  ElementCreator.newDiv().attribute(Attribute.CLASS, "container" + (fluid ? "-fluid" : ""))
		.add(bodyContent());
	
	if (!StringUtils.isEmpty(cssClass)) {
	    div.attribute(Attribute.CLASS, cssClass);
	}
	
	return div;
    }

    public Boolean getFluid() {
	return fluid;
    }

    public void setFluid(Boolean fluid) {
	this.fluid = fluid;
    }
}
