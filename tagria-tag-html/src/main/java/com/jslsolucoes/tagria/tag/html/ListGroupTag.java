
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Ul;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ListGroupTag extends AbstractSimpleTagSupport {

	
	private String cssClass;

	@Override
	public void render() {
		
			Ul ul = new Ul();
			ul.attribute(Attribute.CLASS, "list-group");
			if (!StringUtils.isEmpty(cssClass)) {
				ul.attribute(Attribute.CLASS, cssClass);
			}
			ul.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), ul);
		}
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
