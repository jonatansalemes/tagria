
package com.jslsolucoes.tagria.tag.html.v4.tag.table;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class TableLineTag extends AbstractSimpleTagSupport {

    private String state = "default";

    @Override
    public Element render() {
	return tr();
    }

    private Element tr() {
	return ElementCreator.newTr().attribute(Attribute.CLASS, "bg-" + state).add(bodyContent());
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }
}
