
package com.jslsolucoes.tagria.tag.html.v4.tag.listgroup;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class ListGroupItemTag extends AbstractSimpleTagSupport {

    private String state;

    @Override
    public Element render() {
	return li();
    }

    private Element li() {
	Element li = ElementCreator.newLi().attribute(Attribute.CLASS, "list-group-item").add(bodyContent());
	if (!StringUtils.isEmpty(cssClass)) {
	    li.attribute(Attribute.CLASS, cssClass);
	}
	if (!StringUtils.isEmpty(state)) {
	    li.attribute(Attribute.CLASS, "list-group-item-" + state);
	}
	return li;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

}
