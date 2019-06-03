
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.TextArea;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TextareaTag extends AbstractSimpleTagSupport {

	private String name;
	private String value;
	private String placeholder;
	private Boolean required = Boolean.FALSE;
	private Integer rows = 4;
	private String cssClass;

	@Override
	public void render() {
		TextArea textarea = new TextArea();
		textarea.attribute(Attribute.NAME, name);
		textarea.attribute(Attribute.ROWS, rows);
		textarea.attribute(Attribute.ID, TagUtil.getId(name, null));
		textarea.attribute(Attribute.CLASS, "form-control shadow-sm");

		if (!StringUtils.isEmpty(cssClass)) {
			textarea.attribute(Attribute.CLASS, cssClass);
		}

		if (!StringUtils.isEmpty(placeholder)) {
			textarea.attribute(Attribute.PLACEHOLDER, TagUtil.getLocalized(placeholder, getJspContext()));
		}
		if (!StringUtils.isEmpty(value)) {
			textarea.add(value);
		}
		if (required) {
			textarea.attribute(Attribute.CLASS, "form-required");
			textarea.attribute(Attribute.REQUIRED, "required");
		}
		TagUtil.out(getJspContext(), textarea);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
