package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuDropDownTag extends SimpleTagSupport {

	private String id;
	private String label;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Li li = new Li();
			li.attribute(HtmlAttribute.CLASS, "nav-item dropdown");

			A a = new A();
			a.attribute(HtmlAttribute.HREF, "#");
			a.attribute(HtmlAttribute.ID, TagUtil.getId(id, this));
			a.attribute(HtmlAttribute.CLASS, "nav-link dropdown-toggle");
			a.attribute(HtmlAttribute.DATA_TOGGLE, "dropdown");
			a.add(TagUtil.getLocalized(label, getJspContext()));

			li.add(a);

			Div div = new Div();
			div.attribute(HtmlAttribute.CLASS, "dropdown-menu");
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