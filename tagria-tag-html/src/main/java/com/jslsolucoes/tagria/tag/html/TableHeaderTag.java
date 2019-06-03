
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.THead;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TableHeaderTag extends AbstractSimpleTagSupport {

	private Boolean dark = Boolean.FALSE;
	private Boolean light = Boolean.FALSE;

	@Override
	public void render() {
		THead thead = new THead();

		if (dark) {
			thead.attribute(Attribute.CLASS, "thead-dark");
		}

		if (light) {
			thead.attribute(Attribute.CLASS, "thead-light");
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
