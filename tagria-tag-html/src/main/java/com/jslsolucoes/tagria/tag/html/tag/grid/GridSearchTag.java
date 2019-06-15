package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Input;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridSearchTag extends AbstractSimpleTagSupport {

	@Override
	public void renderOnVoid() {
		Div divForSearch = new Div();
		divForSearch.attribute(Attribute.CLASS, "float-right m-3");
		Input input = new Input();
		input.attribute(Attribute.TYPE, "search");
		input.attribute(Attribute.CLASS, "grid-search form-control");
		input.attribute(Attribute.PLACEHOLDER, keyForLibrary("grid.search"));
		divForSearch.add(input);
		findAncestorWithClass(GridTag.class).setSearch(divForSearch);
	}
}
