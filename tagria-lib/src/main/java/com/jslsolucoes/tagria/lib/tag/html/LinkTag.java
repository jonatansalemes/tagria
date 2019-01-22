
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class LinkTag extends SimpleTagSupport {

	private String url;
	private String label;
	private String target = "_self";
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			A a = new A();
			a.add(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
			a.add(Attribute.TARGET, target);
			if (!StringUtils.isEmpty(label)) {
				a.add(TagUtil.getLocalized(label, getJspContext()));
			} else {
				a.add(TagUtil.getBody(getJspBody()));
			}
			TagUtil.out(getJspContext(), a);
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

}
