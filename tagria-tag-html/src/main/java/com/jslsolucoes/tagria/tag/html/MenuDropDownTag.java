package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class MenuDropDownTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;

	@Override
	public Element render() {
		return li();
	}

	private Element li() {
		return ElementCreator.newLi().attribute(Attribute.CLASS, "nav-item dropdown").add(a()).add(div());
	}

	private Element div() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "dropdown-menu").add(bodyContent());
	}

	private Element a() {
		return ElementCreator.newA().attribute(Attribute.HREF, "#").attribute(Attribute.ID, idForId(id))
				.attribute(Attribute.CLASS, "nav-link dropdown-toggle").attribute(Attribute.DATA_TOGGLE, "dropdown")
				.add(keyOrLabel(labelKey, label));
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