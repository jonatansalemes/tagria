
package com.jslsolucoes.tagria.tag.html.tag.grid;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.html.VarStatus;

public class GridBodyTag extends AbstractSimpleTagSupport {

	public Element render() {
		return tbody();
	}

	private Element tbody() {
		GridTag gridTag = findAncestorWithClass(GridTag.class);
		Collection<Object> data = gridTag.getData();
		String var = gridTag.getVar();
		String varStatus = gridTag.getVarStatus();
		VarStatus varStatusObject = new VarStatus();
		Element tbody = ElementCreator.newTBody();
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
		return tbody;
	}

}
