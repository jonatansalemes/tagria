
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Iframe;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class IframeTag extends AbstractSimpleTagSupport {

	private String name;
	private String id;
	private String url;
	private String cssClass;

	@Override
	public void render() {
		Iframe iframe = new Iframe();
		iframe.attribute(Attribute.CLASS, "iframe");
		if (!StringUtils.isEmpty(cssClass)) {
			iframe.attribute(Attribute.CLASS, cssClass);
		}
		iframe.attribute(Attribute.NAME, name);
		iframe.attribute(Attribute.ID, TagUtil.getId(name, id, this));
		iframe.attribute(Attribute.SRC, TagUtil.getPathForUrl(getJspContext(), url));
		TagUtil.out(getJspContext(), iframe);
		TagUtil.appendJs("$('#" + iframe.attribute(Attribute.ID) + "').iframe();", this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
}
