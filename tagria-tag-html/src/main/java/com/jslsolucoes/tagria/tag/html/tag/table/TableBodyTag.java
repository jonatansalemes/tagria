
package com.jslsolucoes.tagria.tag.html.tag.table;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class TableBodyTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return tbody();
	}

	private Element tbody() {
		return ElementCreator.newTBody().add(bodyContent());
	}

}
