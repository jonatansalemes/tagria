
package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class GridHeaderTag extends AbstractSimpleTagSupport {

	public Element render() {
		return thead();
	}

	private Element thead() {
		return ElementCreator.newTHead().attribute(Attribute.CLASS,"thead-dark").add(tr());
	}

	private Element tr() {
		return ElementCreator.newTr().add(bodyContent());
	}

}
