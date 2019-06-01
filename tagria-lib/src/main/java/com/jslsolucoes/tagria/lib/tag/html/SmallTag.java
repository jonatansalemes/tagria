
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Small;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class SmallTag extends SimpleTagSupport {

	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		Small small = new Small();
		if (!StringUtils.isEmpty(cssClass)) {
			small.add(Attribute.CLASS, cssClass);
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
