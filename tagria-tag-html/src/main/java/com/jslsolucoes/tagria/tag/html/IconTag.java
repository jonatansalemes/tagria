
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class IconTag extends AbstractSimpleTagSupport {

	private String id;
	private String icon;
	

	@Override
	public void render() {
		
			Span span = new Span();
			span.attribute(Attribute.ID, TagUtil.getId(id, this));
			span.attribute(Attribute.CLASS, "fas fa-" + icon);
			TagUtil.out(getJspContext(), span);
		}
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
