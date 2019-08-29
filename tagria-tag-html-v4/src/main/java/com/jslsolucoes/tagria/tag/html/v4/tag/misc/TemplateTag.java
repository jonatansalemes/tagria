package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class TemplateTag extends AbstractSimpleTagSupport {
	
	private String render;

	@Override
	public Element render() {
		return template();
	}

	private Element template() {
		return ElementCreator.newTemplate().attribute("render",render);
	}
	
	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}

}