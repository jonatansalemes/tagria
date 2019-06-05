package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

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