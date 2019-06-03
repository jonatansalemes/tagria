
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ListGroupItemTag extends AbstractSimpleTagSupport {

	
	private String cssClass;
	private String state;

	@Override
	public void render() {
		
			Li li = new Li();
			li.attribute(Attribute.CLASS, "list-group-item");
			if (!StringUtils.isEmpty(cssClass)) {
				li.attribute(Attribute.CLASS, cssClass);
			}
			if (!StringUtils.isEmpty(state)) {
				li.attribute(Attribute.CLASS, "list-group-item-" + state);
			}
			li.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), li);
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
