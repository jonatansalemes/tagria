
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Nav;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class MenuTag extends AbstractSimpleTagSupport {

	private String fixed;

	@Override
	public void render() {

		Nav nav = new Nav();
		nav.attribute(Attribute.CLASS, "navbar navbar-expand-lg navbar-light bg-light");
		if (!StringUtils.isEmpty(fixed)) {
			nav.attribute(Attribute.CLASS, "fixed-" + fixed);
		}
		nav.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), nav);
	}

	public String getFixed() {
		return fixed;
	}

	public void setFixed(String fixed) {
		this.fixed = fixed;
	}
}
