
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TableColumnTag extends AbstractSimpleTagSupport {

	private String state = "default";
	private Integer colspan;
	private String label;
	private String labelKey;

	@Override
	public Element render() {
		return td();
	}

	private Element td() {

		Element td = ElementCreator.newTd().attribute(Attribute.CLASS, "bg-" + state);
		if (colspan != null) {
			td.attribute(Attribute.COLSPAN, colspan);
		}
		if (hasKeyOrLabel(labelKey, label)) {
			td.add(keyOrLabel(labelKey, label));
		} else {
			td.add(bodyContent());
		}
		return td;
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

}
