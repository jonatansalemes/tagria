
package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CardTag extends AbstractSimpleTagSupport {

	private String state = "default";
	private Boolean visible = Boolean.TRUE;

	@Override
	public void render() {
		Element card = card();
		if (!StringUtils.isEmpty(cssClass)) {
			card.attribute(Attribute.CLASS, cssClass);
		}
		if (!visible) {
			card.attribute(Attribute.CLASS, "collapse");
		}
		out(card);
	}

	private Element card() {
		return ElementCreator.newDiv().attribute(Attribute.ID, idForId(id))
				.attribute(Attribute.CLASS, "card bg-" + state).add(bodyContent());
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

}
