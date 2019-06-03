
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.P;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CardTextTag extends AbstractSimpleTagSupport {

	private String cssClass;

	@Override
	public void render() {
		P p = new P();
		p.attribute(Attribute.CLASS, "card-text");
		if (!StringUtils.isEmpty(cssClass)) {
			p.attribute(Attribute.CLASS, cssClass);
		}
		p.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), p);
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
