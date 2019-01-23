package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Li;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuDropDownTag extends SimpleTagSupport {
	
	private String id;
	private String label;
	private Boolean rendered = Boolean.TRUE;
	
	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Li li = new Li();
			li.add(Attribute.CLASS, "nav-item dropdown");
			
			A a = new A();
			a.add(Attribute.HREF, "#");
			a.add(Attribute.ID, TagUtil.getId(id));
			a.add(Attribute.CLASS, "nav-link dropdown-toggle");
			a.add(Attribute.DATA_TOGGLE,"dropdown");
			a.add(TagUtil.getLocalized(label, getJspContext()));	
			
			li.add(a);
			
			Div div = new Div();
			div.add(Attribute.CLASS, "dropdown-menu");
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