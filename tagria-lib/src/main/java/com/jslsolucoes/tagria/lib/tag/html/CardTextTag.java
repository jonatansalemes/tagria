
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.P;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardTextTag extends SimpleTagSupport {

	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		P p = new P();
		p.attribute(HtmlAttribute.CLASS, "card-text");
		if (!StringUtils.isEmpty(cssClass)) {
			p.attribute(HtmlAttribute.CLASS, cssClass);
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
