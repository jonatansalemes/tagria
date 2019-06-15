package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridSearchTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(GridTag.class).setSearch(divSearch());
	}

	private Element divSearch() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "float-right m-3").add(inputSearch());
	}

	private Element inputSearch() {
		return ElementCreator.newInput().attribute(Attribute.TYPE, "search")
				.attribute(Attribute.CLASS, "grid-search form-control")
				.attribute(Attribute.PLACEHOLDER, keyForLibrary("grid.search"));
	}
}
