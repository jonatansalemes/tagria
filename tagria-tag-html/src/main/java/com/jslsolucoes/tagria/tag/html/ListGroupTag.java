
package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class ListGroupTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {

		return ul();
	}

	private Element ul() {
		Element ul = ElementCreator.newUl().attribute(Attribute.CLASS, "list-group").add(bodyContent());
		if (!StringUtils.isEmpty(cssClass)) {
			ul.attribute(Attribute.CLASS, cssClass);
		}
		return ul;
	}

}
