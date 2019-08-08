
package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class H2Tag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return h2();
	}

	private Element h2() {
		return ElementCreator.newH2().add(bodyContent());
	}

}
