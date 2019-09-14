
package com.jslsolucoes.tagria.tag.html.v4.tag.card;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class CardTextTag extends AbstractSimpleTagSupport {
	
	private String label;
	private String labelKey;

	@Override
	public Element render() {
		return p();
	}

	private Element p() {
		Element p = ElementCreator.newP().attribute(Attribute.CLASS, "card-text");

		if (hasKeyOrLabel(labelKey, label)) {
			p.add(keyOrLabel(labelKey, label));
		} else {
			p.add(bodyContent());
		}		
		
		if (!StringUtils.isEmpty(cssClass)) {
			p.attribute(Attribute.CLASS, cssClass);
		}
		return p;
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
