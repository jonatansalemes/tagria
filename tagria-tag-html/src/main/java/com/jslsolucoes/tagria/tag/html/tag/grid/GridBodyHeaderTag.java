
package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridBodyHeaderTag extends AbstractSimpleTagSupport {

	public Element render() {
		return thead();
	}

	private Element thead() {
		return ElementCreator.newTHead().add(tr());
	}

	private Element tr() {
		return ElementCreator.newTr().add(bodyContent());
	}

}
