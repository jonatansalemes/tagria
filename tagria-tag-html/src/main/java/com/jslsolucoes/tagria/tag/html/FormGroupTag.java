
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Label;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class FormGroupTag extends AbstractSimpleTagSupport {

	private String forElement;
	private String label;
	private Boolean required = Boolean.FALSE;
	
	private Boolean visible = Boolean.TRUE;
	private String id;

	@Override
	public void render() {
		
			Div div = new Div();
			div.attribute(Attribute.CLASS, "form-group");

			if (!visible) {
				div.attribute(Attribute.CLASS, "collapse");
			}

			div.attribute(Attribute.ID, TagUtil.getId(id, this));

			if (!StringUtils.isEmpty(label)) {
				Label title = new Label();
				if (!StringUtils.isEmpty(forElement)) {
					title.attribute(Attribute.FOR, TagUtil.getId(forElement, null, this));
				}
				title.add(TagUtil.getLocalized(label, getJspContext()));

				if (required) {
					Span span = new Span();
					span.attribute(Attribute.CLASS, "text-danger");
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
