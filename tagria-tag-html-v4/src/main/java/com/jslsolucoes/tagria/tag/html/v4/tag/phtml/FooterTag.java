package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class FooterTag extends AbstractSimpleTagSupport {

    @Override
    public Element render() {
	return footer();
    }

    private Element footer() {
	Element element = ElementCreator.newFooter().add(bodyContent());
	if (!StringUtils.isEmpty(cssClass)) {
	    element.attribute(Attribute.CLASS, cssClass);
	}
	return element;
    }
}