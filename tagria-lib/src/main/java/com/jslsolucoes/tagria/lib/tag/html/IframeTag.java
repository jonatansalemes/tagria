
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Iframe;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class IframeTag extends SimpleTagSupport {

	private String name;
	private String id;
	private String url;
	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		Iframe iframe = new Iframe();
		iframe.attribute(HtmlAttribute.CLASS, "iframe");
		if (!StringUtils.isEmpty(cssClass)) {
			iframe.attribute(HtmlAttribute.CLASS, cssClass);
		}
		iframe.attribute(HtmlAttribute.NAME, name);
		iframe.attribute(HtmlAttribute.ID, TagUtil.getId(name, id, this));
		iframe.attribute(HtmlAttribute.SRC, TagUtil.getPathForUrl(getJspContext(), url));
		TagUtil.out(getJspContext(), iframe);
		TagUtil.appendJs("$('#" + iframe.attribute(HtmlAttribute.ID) + "').iframe();", this);
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
