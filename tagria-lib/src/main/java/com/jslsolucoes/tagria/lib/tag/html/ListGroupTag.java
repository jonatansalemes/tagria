
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ListGroupTag extends SimpleTagSupport {

	private Boolean rendered = Boolean.TRUE;
	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Ul ul = new Ul();
			ul.add(Attribute.CLASS, "list-group");
			if (!StringUtils.isEmpty(cssClass)) {
				ul.add(Attribute.CLASS, cssClass);
			}
			ul.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), ul);
		}
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
