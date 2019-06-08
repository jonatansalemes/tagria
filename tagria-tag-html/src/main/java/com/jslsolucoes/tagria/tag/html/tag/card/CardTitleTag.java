
package com.jslsolucoes.tagria.tag.html.tag.card;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class CardTitleTag extends AbstractSimpleTagSupport {
	
	private String label;
	private String labelKey;

	@Override
	public Element render() {
		return h5();
	}

	private Element h5() {
		Element h5 = ElementCreator.newH5().attribute(Attribute.CLASS, "card-title");
		if (hasKeyOrLabel(labelKey, label)) {
			h5.add(keyOrLabel(labelKey, label));
		} else {
			h5.add(bodyContent());
		}
		return h5;
	}
	
	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

}
