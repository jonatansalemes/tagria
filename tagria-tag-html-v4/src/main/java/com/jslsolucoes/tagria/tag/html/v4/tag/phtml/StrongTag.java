
package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class StrongTag extends AbstractSimpleTagSupport {

    @Override
    public Element render() {
	return strong();
    }

    private Element strong() {
	Element small = ElementCreator.newStrong().add(bodyContent());
	if (!StringUtils.isEmpty(cssClass)) {
	    small.attribute(Attribute.CLASS, cssClass);
	}
	return small;
    }
}
