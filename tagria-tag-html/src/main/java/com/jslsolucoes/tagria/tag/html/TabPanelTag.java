
package com.jslsolucoes.tagria.tag.html;

import java.util.ArrayList;
import java.util.List;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TabPanelTag extends AbstractSimpleTagSupport {

	private List<Element> lis = new ArrayList<>();
	private List<Element> divs = new ArrayList<>();

	@Override
	public void render() {
		flushBodyContent();
		out(div());
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.ID, id()).add(ul()).add(tabContent());
		appendJsCode("$('#" + div.attribute(Attribute.ID) + "').tabs();");
		return div;
	}

	private Element tabContent() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "tab-content").add(divs);
	}

	private Element ul() {
		return ElementCreator.newUl().attribute(Attribute.CLASS, "nav nav-tabs").add(lis);
	}

	public void addLi(Element element) {
		lis.add(element);
	}

	public void addDiv(Element element) {
		divs.add(element);
	}

}