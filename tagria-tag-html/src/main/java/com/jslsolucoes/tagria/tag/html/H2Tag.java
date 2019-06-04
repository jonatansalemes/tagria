
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class H2Tag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		out(h2());
	}

	private Element h2() {
		return ElementCreator.newH2().add(bodyContent());
	}

}
