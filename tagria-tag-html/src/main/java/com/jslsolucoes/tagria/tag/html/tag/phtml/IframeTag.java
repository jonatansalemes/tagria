
package com.jslsolucoes.tagria.tag.html.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class IframeTag extends AbstractSimpleTagSupport {

	private String name;
	private String url;
	private String title;
	private String titleKey;

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

		if (hasKeyOrLabel(titleKey, title)) {
			iframe.attribute(Attribute.TITLE, keyOrLabel(titleKey, title));
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

}
