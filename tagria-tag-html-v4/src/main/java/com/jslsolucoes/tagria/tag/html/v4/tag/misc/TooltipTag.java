package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class TooltipTag extends AbstractSimpleTagSupport {

	private String attachTo;
	private String attachToSelector;
	private String label;
	private String labelKey;
	private String placement = "top";

	@Override
	public void renderOnVoid() {
		appendJsCode("$('" + attachTo(attachToSelector, attachTo) + "').attr('data-placement','"+placement+"').attr('data-toggle','tooltip').attr('title','"
				+ (hasKeyOrLabel(label, labelKey) ? keyOrLabel(label, labelKey) : bodyContent()) + "').tooltip();");
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public String getAttachToSelector() {
		return attachToSelector;
	}

	public void setAttachToSelector(String attachToSelector) {
		this.attachToSelector = attachToSelector;
	}

	

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

}
