
package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class TextareaTag extends AbstractSimpleTagSupport {

	private String name;
	private String value;
	private String placeHolder;
	private String placeHolderKey;
	private Boolean required = Boolean.FALSE;
	private Integer rows = 4;

	@Override
	public Element render() {
		return textarea();
	}

	private Element textarea() {
		Element textArea = ElementCreator.newTextArea().attribute(Attribute.NAME, name).attribute(Attribute.ROWS, rows)
				.attribute(Attribute.ARIA_LABEL,"textarea")
				.attribute(Attribute.ID, idForName(name)).attribute(Attribute.CLASS, "form-control shadow-sm");
		if (!StringUtils.isEmpty(cssClass)) {
			textArea.attribute(Attribute.CLASS, cssClass);
		}

		if (hasKeyOrLabel(placeHolderKey, placeHolder)) {
			textArea.attribute(Attribute.PLACEHOLDER, keyOrLabel(placeHolderKey, placeHolder));
		}

		if (!StringUtils.isEmpty(value)) {
			textArea.add(value);
		} else {
			textArea.add(bodyContent());
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

	public String getPlaceHolder() {
	    return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
	    this.placeHolder = placeHolder;
	}

	public String getPlaceHolderKey() {
	    return placeHolderKey;
	}

	public void setPlaceHolderKey(String placeHolderKey) {
	    this.placeHolderKey = placeHolderKey;
	}

	

}
