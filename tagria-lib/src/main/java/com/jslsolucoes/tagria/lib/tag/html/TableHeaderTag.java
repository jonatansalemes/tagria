
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Thead;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableHeaderTag extends SimpleTagSupport {

	private Boolean dark = Boolean.FALSE;
	private Boolean light = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {
		Thead thead = new Thead();

		if (dark) {
			thead.add(Attribute.CLASS, "thead-dark");
		}

		if (light) {
			thead.add(Attribute.CLASS, "thead-light");
		}

		thead.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), thead);
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
