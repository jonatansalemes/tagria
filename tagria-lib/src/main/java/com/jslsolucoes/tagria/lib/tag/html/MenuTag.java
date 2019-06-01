
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Nav;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuTag extends SimpleTagSupport {

	private String fixed;

	@Override
	public void doTag() throws JspException, IOException {

		Nav nav = new Nav();
		nav.add(Attribute.CLASS, "navbar navbar-expand-lg navbar-light bg-light");
		if (!StringUtils.isEmpty(fixed)) {
			nav.add(Attribute.CLASS, "fixed-" + fixed);
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
