package com.jslsolucoes.tagria.tag.ajax.v4.tag;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class AjaxAnimationTag extends AbstractSimpleTagSupport {
    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "spinner-grow text-primary ajax-loading")
		.attribute(Attribute.ROLE, "status").add(span());
	if (!StringUtils.isEmpty(cssClass)) {
	    div.attribute(Attribute.CLASS, cssClass);
	}
	return div;
    }

    private Element span() {
	return ElementCreator.newSpan().attribute(Attribute.CLASS, "sr-only").add(keyForLibrary("view.loading"));
    }
}