
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Small;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class SmallTag extends AbstractSimpleTagSupport {

	private String cssClass;

	@Override
	public void render() {
		Small small = new Small();
		if (!StringUtils.isEmpty(cssClass)) {
			small.attribute(Attribute.CLASS, cssClass);
		}
		small.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), small);
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
