
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.P;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardTextTag extends SimpleTagSupport {

	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		P p = new P();
		p.add(Attribute.CLASS, "card-text");
		if (!StringUtils.isEmpty(cssClass)) {
			p.add(Attribute.CLASS, cssClass);
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
