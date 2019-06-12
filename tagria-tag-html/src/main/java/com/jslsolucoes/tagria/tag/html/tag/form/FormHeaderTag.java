package com.jslsolucoes.tagria.tag.html.tag.form;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class FormHeaderTag extends AbstractSimpleTagSupport {

	
	private String label;
	private String labelKey;
	
	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "text-center");
		if(hasKeyOrLabel(labelKey, label)) {
			div.add(h2());
		} else {
			div.add(bodyContent());
		}
		return div;
	}
	
	private Element h2() {
		return ElementCreator.newH2().attribute(Attribute.CLASS, "text-secondary").add(keyOrLabel(labelKey, label));
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
