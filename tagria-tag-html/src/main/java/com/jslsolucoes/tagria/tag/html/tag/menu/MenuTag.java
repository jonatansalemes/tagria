
package com.jslsolucoes.tagria.tag.html.tag.menu;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class MenuTag extends AbstractSimpleTagSupport {

	private String fixed;
	private Boolean dark = Boolean.FALSE;
	private Boolean light = Boolean.FALSE;

	@Override
	public Element render() {
		return nav();
	}

	private Element nav() {
		String navBarClass = navBarClass();
		Element nav = ElementCreator.newNav()
				.attribute(Attribute.CLASS, "navbar navbar-expand-lg navbar-"+navBarClass+" bg-"+navBarClass).add(bodyContent());
		if (!StringUtils.isEmpty(fixed)) {
			nav.attribute(Attribute.CLASS, "fixed-" + fixed);
		}
		return nav;
	}

	private String navBarClass() {
		return light ? "light" : dark ? "dark" : "light";
	}

	public String getFixed() {
		return fixed;
	}

	public void setFixed(String fixed) {
		this.fixed = fixed;
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
