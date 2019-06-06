
package com.jslsolucoes.tagria.tag.html.tag;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class IframeTag extends AbstractSimpleTagSupport {

	private String name;
	private String url;

	@Override
	public Element render() {
		return iframe();
	}

	private Element iframe() {
		Element iframe = ElementCreator.newIframe().attribute(Attribute.CLASS, "iframe").attribute(Attribute.NAME, name)
				.attribute(Attribute.ID, id(name, id)).attribute(Attribute.SRC, pathForUrl(url));
		if (!StringUtils.isEmpty(cssClass)) {
			iframe.attribute(Attribute.CLASS, cssClass);
		}
		appendJsCode("$('#" + iframe.attribute(Attribute.ID) + "').iframe();");
		return iframe;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
