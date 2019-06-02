
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class DropDownItemTag extends SimpleTagSupport {

	private String id;
	private String url = "#";
	private String label;
	private String target = "_self";
	private Boolean rendered = Boolean.TRUE;
	private String icon;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			A a = new A();
			a.attribute(HtmlAttribute.ID, TagUtil.getId(id, this));
			a.attribute(HtmlAttribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
			a.attribute(HtmlAttribute.TARGET, target);
			a.attribute(HtmlAttribute.CLASS, "dropdown-item");

			if (!StringUtils.isEmpty(icon)) {
				a.add(new Span().attribute(HtmlAttribute.CLASS, "fas fa-" + icon));
				a.add(" ");
			}

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

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
