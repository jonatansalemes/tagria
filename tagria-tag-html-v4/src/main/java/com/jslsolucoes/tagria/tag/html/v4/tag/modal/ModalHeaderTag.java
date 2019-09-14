package com.jslsolucoes.tagria.tag.html.v4.tag.modal;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class ModalHeaderTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-header").add(h4());
		if (closeable()) {
			div.add(button());
		}
		return div;
	}
	
	private Boolean closeable() {
		return findAncestorWithClass(ModalTag.class).getCloseable();
	}
	
	private Element h4() {
		return ElementCreator.newH4().attribute(Attribute.CLASS, "modal-title").add(keyOrLabel(labelKey, label));
	}

	private Element button() {
		return ElementCreator.newButton().attribute(Attribute.CLASS, "close").attribute(Attribute.DATA_DISMISS, "modal")
				.add(span());
	}

	private Element span() {
		return ElementCreator.newSpan().add("&times;");
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
