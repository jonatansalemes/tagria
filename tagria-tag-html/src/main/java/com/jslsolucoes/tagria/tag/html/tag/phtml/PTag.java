
package com.jslsolucoes.tagria.tag.html.tag.phtml;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class PTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return p();
	}

	private Element p() {
		return ElementCreator.newP().add(bodyContent());
	}

}
