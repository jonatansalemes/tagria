
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.TextArea;
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
		TextArea textarea = new TextArea();
		textarea.attribute(HtmlAttribute.NAME, name);
		textarea.attribute(HtmlAttribute.ROWS, rows);
		textarea.attribute(HtmlAttribute.ID, TagUtil.getId(name, null));
		textarea.attribute(HtmlAttribute.CLASS, "form-control shadow-sm");

		if (!StringUtils.isEmpty(cssClass)) {
			textarea.attribute(HtmlAttribute.CLASS, cssClass);
		}

		if (!StringUtils.isEmpty(placeholder)) {
			textarea.attribute(HtmlAttribute.PLACEHOLDER, TagUtil.getLocalized(placeholder, getJspContext()));
		}
		if (!StringUtils.isEmpty(value)) {
			textarea.add(value);
		}
		if (required) {
			textarea.attribute(HtmlAttribute.CLASS, "form-required");
			textarea.attribute(HtmlAttribute.REQUIRED, "required");
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
