
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.Span;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class PrintTag extends AbstractSimpleTagSupport {

    @Override
    public Element render() {
	String id = id();
	Element div = div(id);
	appendJsCode("$('#" + id + "').click(function(){window.print();});");
	return div;
    }

    private Element div(String id) {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "print-button").add(button(id));
    }

    private Element button(String id) {
	return ElementCreator.newButton().attribute(Attribute.ID, id).attribute(Attribute.CLASS, "btn btn-secondary")
		.attribute(Attribute.TITLE, keyForLibrary("misc.print.page"))
		.add(new Span().attribute(Attribute.CLASS, "fa fa-print"));
    }

}
