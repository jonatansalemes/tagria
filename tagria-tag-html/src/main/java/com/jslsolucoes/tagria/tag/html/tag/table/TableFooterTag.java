
package com.jslsolucoes.tagria.tag.html.tag.table;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class TableFooterTag extends AbstractSimpleTagSupport {

	private Boolean dark = Boolean.FALSE;
	private Boolean light = Boolean.FALSE;

	@Override
	public Element render() {
		return tfoot();
	}

	private Element tfoot() {
		return ElementCreator.newTFoot().add(bodyContent());
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
