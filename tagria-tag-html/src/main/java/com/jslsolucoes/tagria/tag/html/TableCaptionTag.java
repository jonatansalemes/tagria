
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Caption;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TableCaptionTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;

	@Override
	public Element render() {
		return caption();
	}

	private Element caption() {
		Caption caption = ElementCreator.newCaption();
		if (hasKeyOrLabel(labelKey, label)) {
			caption.add(keyOrLabel(labelKey, label));
		} else {
			caption.add(bodyContent());
		}
		return caption;
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
