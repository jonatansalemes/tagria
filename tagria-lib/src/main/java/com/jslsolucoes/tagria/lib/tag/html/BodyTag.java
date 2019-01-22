
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Body;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class BodyTag extends SimpleTagSupport {

	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		ViewTag viewTag = (ViewTag) findAncestorWithClass(this, ViewTag.class);
		Body body = viewTag.getBody();
		if (!StringUtils.isEmpty(cssClass)) {
			body.add(Attribute.CLASS, cssClass);
		}
		body.add(TagUtil.getBody(getJspBody()));
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
}
