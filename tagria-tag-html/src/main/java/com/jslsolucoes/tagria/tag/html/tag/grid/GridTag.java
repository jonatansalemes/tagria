
package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridTag extends AbstractSimpleTagSupport {

	public Element render() {
		return table();
	}

	private Element table() {
		return ElementCreator.newTable().add(bodyContent());
	}

}
