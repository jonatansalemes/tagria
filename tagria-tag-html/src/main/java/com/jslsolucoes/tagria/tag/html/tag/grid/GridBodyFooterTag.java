
package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridBodyFooterTag extends AbstractSimpleTagSupport {

	public Element render() {
		return tfoot();
	}

	private Element tfoot() {
		return ElementCreator.newTFoot().add(bodyContent());
	}

}
