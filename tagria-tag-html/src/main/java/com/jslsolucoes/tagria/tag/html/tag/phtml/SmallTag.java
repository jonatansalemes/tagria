
package com.jslsolucoes.tagria.tag.html.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class SmallTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return small();
	}

	private Element small() {
		Element small = ElementCreator.newSmall().add(bodyContent());
		if (!StringUtils.isEmpty(cssClass)) {
			small.attribute(Attribute.CLASS, cssClass);
		}
		return small;
	}
}
