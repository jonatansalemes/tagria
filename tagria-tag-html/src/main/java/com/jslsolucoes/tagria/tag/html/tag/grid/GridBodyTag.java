
package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridBodyTag extends AbstractSimpleTagSupport {

	public Element render() {
		return div();
	}
	
	private Element div() {
		return ElementCreator.newDiv().add(table());
	}

	private Element table() {
		return ElementCreator.newTable().add(bodyContent());
	}
}
