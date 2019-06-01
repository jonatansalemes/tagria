package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuCollapsableTag extends SimpleTagSupport {

	private String id;

	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		div.attribute(HtmlAttribute.ID, TagUtil.getId(id, this));
		div.attribute(HtmlAttribute.CLASS, "collapse navbar-collapse");

		Ul ul = new Ul();
		ul.attribute(HtmlAttribute.CLASS, "navbar-nav mr-auto");
		ul.add(TagUtil.getBody(getJspBody()));
		div.add(ul);

		TagUtil.out(getJspContext(), div);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
