package com.jslsolucoes.tagria.tag.html.tag.modal;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class ModalBodyTag extends AbstractSimpleTagSupport {
	
	@Override
	public Element render() {
		return div();
	}
	
	private Element div() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-body").add(bodyContent());
	}

}
