package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridToolbarTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(GridTag.class).setToolbar(div());
	}

	private Element div() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "float-left m-3").add(bodyContent());
	}
}
