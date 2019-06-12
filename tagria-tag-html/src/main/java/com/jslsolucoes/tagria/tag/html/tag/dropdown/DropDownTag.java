package com.jslsolucoes.tagria.tag.html.tag.dropdown;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class DropDownTag extends AbstractSimpleTagSupport {

	private String id;
	private String label;
	private String labelKey;
	private String state = "primary";
	private String size;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "dropdown").add(button()).add(divDropDown());
	}

	private Element divDropDown() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "dropdown-menu").add(bodyContent());
	}

	private Element button() {
		Element button = ElementCreator.newButton().attribute(Attribute.TYPE, "button")
				.attribute(Attribute.ID, idForId(id))
				.attribute(Attribute.CLASS, "btn btn-outline-" + state + " shadow-sm dropdown-toggle")
				.attribute(Attribute.DATA_TOGGLE, "dropdown").add(keyOrLabel(labelKey, label));
		if (!StringUtils.isEmpty(size)) {
			button.attribute(Attribute.CLASS, "btn-" + size);
		}
		return button;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}
}