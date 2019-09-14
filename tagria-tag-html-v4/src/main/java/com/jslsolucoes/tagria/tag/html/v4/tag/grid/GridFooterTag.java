
package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class GridFooterTag extends AbstractSimpleTagSupport {

	public Element render() {
		return tfoot();
	}

	private Element tfoot() {
		return ElementCreator.newTFoot().add(bodyContent());
	}

}
