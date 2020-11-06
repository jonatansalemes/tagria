
package com.jslsolucoes.tagria.tag.html.v4.tag.card;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class CardBodyTag extends AbstractSimpleTagSupport {

    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "card-body").add(bodyContent());
	
	if (!StringUtils.isEmpty(cssClass)) {
	    div.attribute(Attribute.CLASS, cssClass);
	}
	
	return div;
    }

}
