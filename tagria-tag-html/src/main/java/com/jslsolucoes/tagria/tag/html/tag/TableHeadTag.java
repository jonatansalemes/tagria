
package com.jslsolucoes.tagria.tag.html.tag;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class TableHeadTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;

	@Override
	public Element render() {
		return th();
	}

	private Element th() {
		Element th = ElementCreator.newTh();
		if (hasKeyOrLabel(labelKey, label)) {
			th.add(keyOrLabel(labelKey, label));
		} else {
			th.add(bodyContent());
		}
		return th;
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
