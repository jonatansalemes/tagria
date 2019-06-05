
package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TextareaTag extends AbstractSimpleTagSupport {

	private String name;
	private String value;
	private String placeholder;
	private String placeholderKey;
	private Boolean required = Boolean.FALSE;
	private Integer rows = 4;

	@Override
	public Element render() {
		return textarea();
	}

	private Element textarea() {
		Element textArea = ElementCreator.newTextArea().attribute(Attribute.NAME, name).attribute(Attribute.ROWS, rows)
				.attribute(Attribute.ID, idForName(name)).attribute(Attribute.CLASS, "form-control shadow-sm");
		if (!StringUtils.isEmpty(cssClass)) {
			textArea.attribute(Attribute.CLASS, cssClass);
		}

		if (hasKeyOrLabel(placeholderKey, placeholder)) {
			textArea.attribute(Attribute.PLACEHOLDER, keyOrLabel(placeholderKey, placeholder));
		}

		if (!StringUtils.isEmpty(value)) {
			textArea.add(value);
		}
		if (required) {
			textArea.attribute(Attribute.CLASS, "form-required");
			textArea.attribute(Attribute.REQUIRED, "required");
		}
		return textArea;
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

	public String getPlaceholderKey() {
		return placeholderKey;
	}

	public void setPlaceholderKey(String placeholderKey) {
		this.placeholderKey = placeholderKey;
	}

}
