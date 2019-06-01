
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuBrandTag extends SimpleTagSupport {

	private String url;
	private String label;

	@Override
	public void doTag() throws JspException, IOException {

		A a = new A();
		a.attribute(HtmlAttribute.CLASS, "navbar-brand");
		a.attribute(HtmlAttribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
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
