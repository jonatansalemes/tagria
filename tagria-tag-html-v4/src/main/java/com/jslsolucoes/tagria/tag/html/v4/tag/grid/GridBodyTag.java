
package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.html.v4.VarStatus;

public class GridBodyTag extends AbstractSimpleTagSupport {

    public Element render() {
	return tbody();
    }

    private Element tbody() {
	GridTag gridTag = findAncestorWithClass(GridTag.class);
	Collection<Object> data = gridTag.dataSet();
	String var = gridTag.getVar();
	String varStatus = gridTag.getVarStatus();
	String noRowText = gridTag.getNoRowText();
	String noRowTextKey = gridTag.getNoRowTextKey();
	VarStatus varStatusObject = new VarStatus();
	Element tbody = ElementCreator.newTBody();
	if (!CollectionUtils.isEmpty(data)) {
	    for (Object row : data) {
		setAttribute(var, row);
		if (!StringUtils.isEmpty(varStatus)) {
		    setAttribute(varStatus, varStatusObject);
		}
		tbody.add(ElementCreator.newTr().add(bodyContent()));
		varStatusObject.increment();
	    }
	    setAttribute(var, null);
	    if (!StringUtils.isEmpty(varStatus)) {
		setAttribute(varStatus, null);
	    }
	} else {
	    tbody.add(tr(noRowTextKey,noRowText));
	}
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
