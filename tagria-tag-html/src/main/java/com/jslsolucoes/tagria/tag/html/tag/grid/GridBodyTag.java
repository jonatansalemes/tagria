
package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridBodyTag extends AbstractSimpleTagSupport {

	public Element render() {
		return ElementCreator.newDiv().add(bodyContent());
	}

}
