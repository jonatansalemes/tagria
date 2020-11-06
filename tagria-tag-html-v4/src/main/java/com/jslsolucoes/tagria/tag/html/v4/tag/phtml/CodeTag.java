
package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

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
