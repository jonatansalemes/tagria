
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class RowTag extends AbstractSimpleTagSupport {

	private String cssClass;

	@Override
	public void render() {
		Div div = new Div();
		div.attribute(Attribute.CLASS, "row");

		if (!StringUtils.isEmpty(cssClass)) {
			div.attribute(Attribute.CLASS, cssClass);
		}
		div.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), div);
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
