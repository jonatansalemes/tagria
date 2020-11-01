package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class SpinnerTag extends AbstractSimpleTagSupport {

    private String type = "grow";
    private String state = "primary";
    private String label;
    private String labelKey;

    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "alert spinner-" + type + " text-" + state)
		.attribute(Attribute.ROLE, "status").add(span());
    }

    private Element span() {
	Element span = ElementCreator.newSpan();
	if (hasKeyOrLabel(labelKey, label)) {
	    span.add(keyOrLabel(labelKey, label));
	} else {
	    span.add(bodyContent());
	}
	return span;
    }
}
