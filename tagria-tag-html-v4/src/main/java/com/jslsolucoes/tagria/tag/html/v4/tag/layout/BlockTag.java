package com.jslsolucoes.tagria.tag.html.v4.tag.layout;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class BlockTag extends AbstractSimpleTagSupport {

    private Integer margin = 3;
    private String align;

    @Override
    public Element render() {
	return div();
    }

    public Element div() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "mt-" + margin + " mb-" + margin + " clearfix")
		.add(bodyContent());
	if (!StringUtils.isEmpty(align)) {
	    div.attribute(Attribute.CLASS, "text-" + align);
	}
	if (!StringUtils.isEmpty(cssClass)) {
	    div.attribute(Attribute.CLASS, cssClass);
	}
	return div;
    }

    public Integer getMargin() {
	return margin;
    }

    public void setMargin(Integer margin) {
	this.margin = margin;
    }

    public String getAlign() {
	return align;
    }

    public void setAlign(String align) {
	this.align = align;
    }

}