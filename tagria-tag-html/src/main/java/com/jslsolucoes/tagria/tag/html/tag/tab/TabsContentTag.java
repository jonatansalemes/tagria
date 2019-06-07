
package com.jslsolucoes.tagria.tag.html.tag.tab;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class TabsContentTag extends AbstractSimpleTagSupport {

	private String url;
	private Boolean active = Boolean.FALSE;
	private String contentOf;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "tab-pane m-2").attribute(Attribute.ID, idForId(contentOf));
		if (active) {
			div.attribute(Attribute.CLASS, "active");
		}
		if (StringUtils.isEmpty(url)) {
			div.add(bodyContent());
		} else {
			div.add(iframe());
		}
		return div;
	}

	private Element iframe() {
		Element iframe = ElementCreator.newIframe().attribute(Attribute.CLASS, "iframe").attribute(Attribute.ID, id())
				.attribute(Attribute.SRC, pathForBlank()).attribute(Attribute.DATA_URL, pathForUrl(url));
		if (active) {
			iframe.attribute(Attribute.CLASS, "active");
		}
		appendJsCode("$('#" + iframe.attribute(Attribute.ID) + "').iframe();");
		return iframe;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentOf() {
		return contentOf;
	}

	public void setContentOf(String contentOf) {
		this.contentOf = contentOf;
	}


}
