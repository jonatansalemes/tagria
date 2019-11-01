
package com.jslsolucoes.tagria.tag.html.v4.tag.table;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class TableBodyTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return tbody();
	}

	private Element tbody() {
		return ElementCreator.newTBody().add(bodyContent());
	}

}
