package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuDropDownTag extends AbstractSimpleTagSupport {

	private String id;
	private String label;
	

	@Override
	public void render() {
		
			Li li = new Li();
			li.attribute(Attribute.CLASS, "nav-item dropdown");

			A a = new A();
			a.attribute(Attribute.HREF, "#");
			a.attribute(Attribute.ID, TagUtil.getId(id, this));
			a.attribute(Attribute.CLASS, "nav-link dropdown-toggle");
			a.attribute(Attribute.DATA_TOGGLE, "dropdown");
			a.add(TagUtil.getLocalized(label, getJspContext()));

			li.add(a);

			Div div = new Div();
			div.attribute(Attribute.CLASS, "dropdown-menu");
			div.add(TagUtil.getBody(getJspBody()));
			li.add(div);

			TagUtil.out(getJspContext(), li);
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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