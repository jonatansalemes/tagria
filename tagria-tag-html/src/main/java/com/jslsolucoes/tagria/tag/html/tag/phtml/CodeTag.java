
package com.jslsolucoes.tagria.tag.html.tag.phtml;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class CodeTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return pre();
	}

	private Element pre() {
		return ElementCreator.newPre().add(code());
	}

	private Element code() {
		return ElementCreator.newCode().add(bodyContentEscape());
	}

	private String bodyContentEscape() {
		return bodyContent().replaceAll(">", "&gt;").replaceAll("<", "&lt;");
	}
}
