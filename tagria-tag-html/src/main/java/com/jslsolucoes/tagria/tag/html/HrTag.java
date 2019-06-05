
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class HrTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return hr();
	}

	private Element hr() {
		return ElementCreator.newHr();
	}
}
