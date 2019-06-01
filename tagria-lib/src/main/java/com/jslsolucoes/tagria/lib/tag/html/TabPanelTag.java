
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.HtmlTag;
import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TabPanelTag extends SimpleTagSupport {

	private List<HtmlTag> lis = new ArrayList<>();
	private List<HtmlTag> divs = new ArrayList<>();

	@Override
	public void doTag() throws JspException, IOException {

		TagUtil.flushBody(getJspBody());

		Div div = new Div();
		div.attribute(HtmlAttribute.ID, TagUtil.getId(this));

		Ul ul = new Ul();
		ul.attribute(HtmlAttribute.CLASS, "nav nav-tabs");
		ul.add(lis);
		div.add(ul);

		Div tabs = new Div();
		tabs.attribute(HtmlAttribute.CLASS, "tab-content");
		tabs.add(divs);
		div.add(tabs);

		TagUtil.out(getJspContext(), div);
		TagUtil.appendJs("$('#" + div.attribute(HtmlAttribute.ID) + "').tabs();", this);
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