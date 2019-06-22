
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
	private Boolean dark = Boolean.FALSE;
	private Boolean light = Boolean.FALSE;
	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {

		String bgCssClass = bgCssClass();
		Nav nav = new Nav();
		nav.add(Attribute.CLASS, "navbar navbar-expand-lg navbar-" + bgCssClass + " bg-" + bgCssClass);
		if (!StringUtils.isEmpty(cssClass)) {
			nav.add(Attribute.CLASS, cssClass);
		}

		if (!StringUtils.isEmpty(fixed)) {
			nav.add(Attribute.CLASS, "fixed-" + fixed);
		}
		nav.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), nav);
	}

	private String bgCssClass() {
		return (light ? "light" : dark ? "dark" : "light");
	}

	public String getFixed() {
		return fixed;
	}

	public void setFixed(String fixed) {
		this.fixed = fixed;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public Boolean getDark() {
		return dark;
	}

	public void setDark(Boolean dark) {
		this.dark = dark;
	}

	public Boolean getLight() {
		return light;
	}

	public void setLight(Boolean light) {
		this.light = light;
	}
}
