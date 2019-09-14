package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
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
	    Element template = ElementCreator.newTemplate().attribute(Attribute.DATA_RENDER,render);
	    String bodyContent = bodyContent();
	    if(!StringUtils.isEmpty(bodyContent)) {
		template.add(bodyContent);
	    }
	    return template;
	}
	
	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}

}