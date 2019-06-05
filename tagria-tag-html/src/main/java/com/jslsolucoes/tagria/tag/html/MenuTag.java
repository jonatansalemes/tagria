
package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class MenuTag extends AbstractSimpleTagSupport {

	private String fixed;

	@Override
	public Element render() {
		return nav();
	}

	private Element nav() {
		Element nav = ElementCreator.newNav()
				.attribute(Attribute.CLASS, "navbar navbar-expand-lg navbar-light bg-light").add(bodyContent());
		if (!StringUtils.isEmpty(fixed)) {
			nav.attribute(Attribute.CLASS, "fixed-" + fixed);
		}
		return nav;
	}

	public String getFixed() {
		return fixed;
	}

	public void setFixed(String fixed) {
		this.fixed = fixed;
	}
}
