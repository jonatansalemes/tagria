
package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class GridBodyTag extends AbstractSimpleTagSupport {

    public Element render() {
	return tbody();
    }

    private Element tbody() {
	GridTag gridTag = findAncestorWithClass(GridTag.class);
	String noRowText = gridTag.getNoRowText();
	String noRowTextKey = gridTag.getNoRowTextKey();
	Element tbody = ElementCreator.newTBody();
	gridTag.iterateOver(object -> {
	    tbody.add(ElementCreator.newTr().add(bodyContent()));
	}, () -> {
	    tbody.add(tr(noRowTextKey, noRowText));
	});
	return tbody;
    }

    private Element tr(String noRowTextKey, String noRowText) {
	return ElementCreator.newTr().add(td(noRowTextKey, noRowText));
    }

    private Element td(String noRowTextKey, String noRowText) {
	return ElementCreator.newTd().attribute(Attribute.CLASS, "text-center").attribute(Attribute.COLSPAN, "100")
		.add(divNoRow(noRowTextKey, noRowText));
    }

    private Element divNoRow(String noRowTextKey, String noRowText) {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "alert alert-info").attribute(Attribute.ROLE, "alert")
		.add((hasKeyOrLabel(noRowTextKey, noRowText) ? keyOrLabel(noRowTextKey, noRowText)
			: keyForLibrary("grid.no.row")));
    }

}
