
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class RowTag extends SimpleTagSupport {

	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		div.attribute(HtmlAttribute.CLASS, "row");

		if (!StringUtils.isEmpty(cssClass)) {
			div.attribute(HtmlAttribute.CLASS, cssClass);
		}
		div.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), div);
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
