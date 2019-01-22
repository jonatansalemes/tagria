
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Label;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class FormGroupTag extends SimpleTagSupport {

	private String forElement;
	private String label;
	private Boolean required = Boolean.FALSE;
	private Boolean rendered = Boolean.TRUE;
	private Boolean visible = Boolean.TRUE;
	private String id;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Div div = new Div();
			div.add(Attribute.CLASS, "form-group");

			if (!visible) {
				div.add(Attribute.CLASS, "collapse");
			}

			div.add(Attribute.ID, TagUtil.getId(id));

			if (!StringUtils.isEmpty(label)) {
				Label title = new Label();
				if (!StringUtils.isEmpty(forElement)) {
					title.add(Attribute.FOR, TagUtil.getId(forElement, null));
				}
				title.add(TagUtil.getLocalized(label, getJspContext()));

				if (required) {
					Span span = new Span();
					span.add(Attribute.CLASS, "text-danger");
					span.add(" * ");
					title.add(span);
				}
				div.add(title);
			}

			div.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), div);
		}
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

	public String getForElement() {
		return forElement;
	}

	public void setForElement(String forElement) {
		this.forElement = forElement;
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
}
