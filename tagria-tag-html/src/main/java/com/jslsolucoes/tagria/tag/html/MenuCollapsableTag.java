package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class MenuCollapsableTag extends AbstractSimpleTagSupport {

	private String id;

	@Override
	public void render() {
		Div div = new Div();
		div.attribute(Attribute.ID, TagUtil.getId(id, this));
		div.attribute(Attribute.CLASS, "collapse navbar-collapse");

		Ul ul = new Ul();
		ul.attribute(Attribute.CLASS, "navbar-nav mr-auto");
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
