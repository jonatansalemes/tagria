
package com.jslsolucoes.tagria.tag.html;

import java.util.ArrayList;
import java.util.List;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;

import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TabPanelTag extends AbstractSimpleTagSupport {

	private List<HtmlTag> lis = new ArrayList<>();
	private List<HtmlTag> divs = new ArrayList<>();

	@Override
	public void render() {

		TagUtil.flushBody(getJspBody());

		Div div = new Div();
		div.attribute(Attribute.ID, TagUtil.getId(this));

		Ul ul = new Ul();
		ul.attribute(Attribute.CLASS, "nav nav-tabs");
		ul.add(lis);
		div.add(ul);

		Div tabs = new Div();
		tabs.attribute(Attribute.CLASS, "tab-content");
		tabs.add(divs);
		div.add(tabs);

		TagUtil.out(getJspContext(), div);
		TagUtil.appendJs("$('#" + div.attribute(Attribute.ID) + "').tabs();", this);
	}

	public void addLi(Li element) {
		lis.add(element);
	}

	public void addDiv(Div element) {
		divs.add(element);
	}

	public List<HtmlTag> getLis() {
		return lis;
	}

	public void setLis(List<HtmlTag> lis) {
		this.lis = lis;
	}

	public List<HtmlTag> getDivs() {
		return divs;
	}

	public void setDivs(List<HtmlTag> divs) {
		this.divs = divs;
	}
}