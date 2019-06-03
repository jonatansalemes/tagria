
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class MenuBrandTag extends AbstractSimpleTagSupport {

	private String url;
	private String label;

	@Override
	public void render() {

		A a = new A();
		a.attribute(Attribute.CLASS, "navbar-brand");
		a.attribute(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
		if (!StringUtils.isEmpty(label)) {
			a.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			a.add(TagUtil.getBody(getJspBody()));
		}

		TagUtil.out(getJspContext(), a);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
