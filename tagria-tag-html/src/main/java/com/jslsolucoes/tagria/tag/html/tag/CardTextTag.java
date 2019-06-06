
package com.jslsolucoes.tagria.tag.html.tag;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class CardTextTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return p();
	}

	private Element p() {
		Element p = ElementCreator.newP().attribute(Attribute.CLASS, "card-text").add(bodyContent());
		if (!StringUtils.isEmpty(cssClass)) {
			p.attribute(Attribute.CLASS, cssClass);
		}
		return p;
	}
}
