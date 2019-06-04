
package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class DivTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		Element div = div();
		if (!StringUtils.isEmpty(cssClass)) {
			div.attribute(Attribute.CLASS, cssClass);
		}
		out(div);
	}

	private Element div() {
		return ElementCreator.newDiv().attribute(Attribute.ID, idForId(id)).add(bodyContent());
	}

}
