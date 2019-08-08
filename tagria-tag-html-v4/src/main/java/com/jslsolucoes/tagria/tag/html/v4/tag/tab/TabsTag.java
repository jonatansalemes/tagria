package com.jslsolucoes.tagria.tag.html.v4.tag.tab;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class TabsTag extends AbstractSimpleTagSupport {
	
	private String afterShow;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.ID, id()).add(bodyContent());
		String afterShowFunction = (!StringUtils.isEmpty(afterShow) ? afterShow + "(oldTab,newTab);": "");
		appendJsCode("$('#" + div.attribute(Attribute.ID) + "').tabs({ afterShow : function(oldTab,newTab) {"+afterShowFunction+"} });");
		return div;
	}

	public String getAfterShow() {
		return afterShow;
	}

	public void setAfterShow(String afterShow) {
		this.afterShow = afterShow;
	}
	
}
