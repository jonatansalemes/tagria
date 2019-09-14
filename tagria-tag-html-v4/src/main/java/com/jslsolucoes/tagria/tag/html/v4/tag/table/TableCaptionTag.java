
package com.jslsolucoes.tagria.tag.html.v4.tag.table;

import com.jslsolucoes.tagria.html.v4.Caption;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
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
