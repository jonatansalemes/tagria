
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TableHeaderTag extends AbstractSimpleTagSupport {

	private Boolean dark = Boolean.FALSE;
	private Boolean light = Boolean.FALSE;

	@Override
	public void render() {
		Element thead = thead();
		if (dark) {
			thead.attribute(Attribute.CLASS, "thead-dark");
		}
		if (light) {
			thead.attribute(Attribute.CLASS, "thead-light");
		}
		out(thead);
	}

	private Element thead() {
		return ElementCreator.newTHead().add(bodyContent());
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
