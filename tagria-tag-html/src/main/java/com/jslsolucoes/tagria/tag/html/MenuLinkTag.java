package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuLinkTag extends AbstractSimpleTagSupport {

	private String url = "#";
	private String label;
	private String target = "_self";
	private String icon;
	private String id;
	

	@Override
	public void render() {
		

			A a = new A();
			a.attribute(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
			a.attribute(Attribute.TARGET, target);
			a.attribute(Attribute.ID, TagUtil.getId(id, this));
			a.attribute(Attribute.CLASS, "nav-link");

			if (!StringUtils.isEmpty(icon)) {
				a.add(new Span().attribute(Attribute.CLASS, "fas fa-" + icon));
				a.add(" ");
			}

			if (!StringUtils.isEmpty(label)) {
				a.add(TagUtil.getLocalized(label, getJspContext()));
			} else {
				a.add(TagUtil.getBody(getJspBody()));
			}
			Li li = new Li();
			li.attribute(Attribute.CLASS, "nav-item");
			li.add(a);
			TagUtil.out(getJspContext(), li);
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}