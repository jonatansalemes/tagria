
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Textarea;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TextareaTag extends SimpleTagSupport {

	private String name;
	private String value;
	private String placeholder;
	private Boolean required = Boolean.FALSE;
	private Integer rows = 4;
	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		Textarea textarea = new Textarea();
		textarea.add(Attribute.NAME, name);
		textarea.add(Attribute.ROWS, rows);
		textarea.add(Attribute.ID, TagUtil.getId(name, null, this));
		textarea.add(Attribute.CLASS, "form-control shadow-sm");

		if (!StringUtils.isEmpty(cssClass)) {
			textarea.add(Attribute.CLASS, cssClass);
		}

		if (!StringUtils.isEmpty(placeholder)) {
			textarea.add(Attribute.PLACEHOLDER, TagUtil.getLocalized(placeholder, getJspContext()));
		}
		if (!StringUtils.isEmpty(value)) {
			textarea.add(value);
		}
		if (required) {
			textarea.add(Attribute.CLASS, "form-required");
			textarea.add(Attribute.REQUIRED, "required");
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
