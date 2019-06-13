
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

}
