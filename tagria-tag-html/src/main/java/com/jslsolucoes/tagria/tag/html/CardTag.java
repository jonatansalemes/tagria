
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardTag extends AbstractSimpleTagSupport {

	private String state = "default";
	private String id;
	
	private Boolean visible = Boolean.TRUE;
	private String cssClass;

	@Override
	public void render() {
		
			Div div = new Div();
			div.attribute(Attribute.ID, TagUtil.getId(id, this));
			div.attribute(Attribute.CLASS, "card bg-" + state);
			if (!StringUtils.isEmpty(cssClass)) {
				div.attribute(Attribute.CLASS, cssClass);
			}
			div.add(TagUtil.getBody(getJspBody()));
			if (!visible) {
				div.attribute(Attribute.CLASS, "collapse");
			}
			TagUtil.out(getJspContext(), div);
		}
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
}
