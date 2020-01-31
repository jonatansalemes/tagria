
package com.jslsolucoes.tagria.tag.html.v4.tag.listgroup;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class ListGroupTag extends AbstractSimpleTagSupport {

    private Boolean flushable = Boolean.FALSE;
    private Boolean horizontal = Boolean.FALSE;

    @Override
    public Element render() {

	return ul();
    }

    private Element ul() {
	Element ul = ElementCreator.newUl().attribute(Attribute.CLASS, "list-group").add(bodyContent());
	if (!StringUtils.isEmpty(cssClass)) {
	    ul.attribute(Attribute.CLASS, cssClass);
	}

	if (flushable) {
	    ul.attribute(Attribute.CLASS, "list-group-flush");
	}

	if (horizontal) {
	    ul.attribute(Attribute.CLASS, "list-group-horizontal");
	}

	return ul;
    }

    public Boolean getFlushable() {
	return flushable;
    }

    public void setFlushable(Boolean flushable) {
	this.flushable = flushable;
    }

    public Boolean getHorizontal() {
	return horizontal;
    }

    public void setHorizontal(Boolean horizontal) {
	this.horizontal = horizontal;
    }

}
