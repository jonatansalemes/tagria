
package com.jslsolucoes.tagria.tag.html.v4.tag.listgroup;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
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
