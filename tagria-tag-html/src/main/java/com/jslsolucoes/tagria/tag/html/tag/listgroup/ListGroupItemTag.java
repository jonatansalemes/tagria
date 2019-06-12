
package com.jslsolucoes.tagria.tag.html.tag.listgroup;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

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
