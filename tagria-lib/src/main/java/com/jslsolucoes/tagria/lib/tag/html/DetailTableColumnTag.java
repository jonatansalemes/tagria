
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Td;
import com.jslsolucoes.tagria.lib.html.Th;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class DetailTableColumnTag extends SimpleTagSupport {

	private String label;
	private Boolean required = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {

		DetailTableTag detail = (DetailTableTag) findAncestorWithClass(this, DetailTableTag.class);

		Th th = new Th();
		th.add(TagUtil.getLocalized(label, getJspContext()));
		if (required) {
			Span span = new Span();
			span.add(Attribute.CLASS, "text-danger");
			span.add(" * ");
			th.add(span);
		}
		detail.add(th);

		Td td = new Td();
		td.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), td);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

}
