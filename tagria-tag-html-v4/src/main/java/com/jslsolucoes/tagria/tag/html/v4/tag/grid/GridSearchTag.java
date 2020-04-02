package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class GridSearchTag extends AbstractSimpleTagSupport {

    @Override
    public void renderOnVoid() {
	findAncestorWithClass(GridTag.class).setSearch(divSearch());
    }

    private Element divSearch() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "m-3").add(inputTextContainer());
    }
    
    public Element inputTextContainer() {
	Element container = ElementCreator.newDiv()
		.attribute(Attribute.ID, id())
		.attribute(Attribute.CLASS, "form-control-container").add(inputSearch())
		.add(ripple());
	appendJsCode("$('#" + container.attribute(Attribute.ID) + "').input();");
	return container;
    }
    
    private Element ripple() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "form-control-container-line-ripple");
    }

    private Element inputSearch() {
	return ElementCreator.newInput().attribute(Attribute.TYPE, "search")
		.attribute(Attribute.CLASS, "grid-search form-control ")
		.attribute(Attribute.ARIA_LABEL, keyForLibrary("grid.search"))
		.attribute(Attribute.PLACEHOLDER, keyForLibrary("grid.search"));
    }
}
