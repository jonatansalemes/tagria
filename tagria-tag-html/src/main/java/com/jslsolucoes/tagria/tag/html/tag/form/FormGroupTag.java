
package com.jslsolucoes.tagria.tag.html.tag.form;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class FormGroupTag extends AbstractSimpleTagSupport {

	private String forElement;
	private String label;
	private String labelKey;
	private Boolean required = Boolean.FALSE;
	private Boolean visible = Boolean.TRUE;
	

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		Element div =  ElementCreator.newDiv().attribute(Attribute.CLASS, "form-group")
				.attribute(Attribute.ID, idForId(id));
		if (!visible) {
			div.attribute(Attribute.CLASS, "collapse");
		}

		if (hasKeyOrLabel(labelKey, label)) {
			div.add(label());
		}
		div.add(bodyContent());
		return div;
	}

	private Element label() {
		Element label = ElementCreator.newLabel().add(keyOrLabel(labelKey, this.label));
		if (!StringUtils.isEmpty(forElement)) {
			label.attribute(Attribute.FOR, idForName(forElement));
		}
		if (required) {
			label.add(span());
		}
		return label;
	}
	
	private Element span() {
		return ElementCreator.newSpan()
		.attribute(Attribute.CLASS, "text-danger")
		.add(" * ");
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


	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}
}
