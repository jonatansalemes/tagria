package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;
import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.H3;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class H3Tag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;

	@Override
	public Element render() {
		return h3();
	}

	private Element h3() {
		H3 h3 = ElementCreator.newH3();
		if (hasKeyOrLabel(labelKey, label)) {
			h3.add(keyOrLabel(labelKey, label));
		} else {
			h3.add(bodyContent());
		}
		
		if (!StringUtils.isEmpty(cssClass)) {
			h3.attribute(Attribute.CLASS, cssClass);
		}
		
		return h3;
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