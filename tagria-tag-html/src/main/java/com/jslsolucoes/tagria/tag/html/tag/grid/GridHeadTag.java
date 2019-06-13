
package com.jslsolucoes.tagria.tag.html.tag.grid;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridHeadTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;
	private String align = "left";
	private Boolean exportable = Boolean.FALSE;

	public Element render() {
		return th();
	}

	private Element th() {
		Element th = ElementCreator.newTh().attribute(Attribute.CLASS, "text-" + align);
		if (exportable) {
			th.attribute(Attribute.CLASS, "grid-column-exportable");
		}
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

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public Boolean getExportable() {
		return exportable;
	}

	public void setExportable(Boolean exportable) {
		this.exportable = exportable;
	}

}
