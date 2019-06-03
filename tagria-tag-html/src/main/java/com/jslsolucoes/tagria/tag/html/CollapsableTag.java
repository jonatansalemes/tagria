
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.H5;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CollapsableTag extends AbstractSimpleTagSupport {

	private String label;
	private Boolean opened = Boolean.FALSE;

	@Override
	public void render() {

		Div card = new Div();
		card.attribute(Attribute.CLASS, "card");
		card.attribute(Attribute.ID, TagUtil.getId(this));

		Div cardHeader = new Div();
		cardHeader.attribute(Attribute.CLASS, "card-header");
		H5 h5 = new H5();
		h5.attribute(Attribute.CLASS, "mb-0");

		String idTarget = TagUtil.getId(this);
		Button button = new Button();
		button.attribute(Attribute.CLASS, "btn btn-link");
		button.attribute(Attribute.DATA_TOGGLE, "collapse");
		button.attribute(Attribute.DATA_TARGET, "#" + idTarget);
		button.attribute(Attribute.ID, TagUtil.getId(this));
		button.add(TagUtil.getLocalized(label, getJspContext()));
		h5.add(button);

		cardHeader.add(h5);

		card.add(cardHeader);

		Div content = new Div();
		content.attribute(Attribute.ID, idTarget);
		content.attribute(Attribute.CLASS, "collapse " + (opened ? "show" : ""));

		Div cardBody = new Div();
		cardBody.attribute(Attribute.CLASS, "card-body");
		cardBody.add(TagUtil.getBody(getJspBody()));

		content.add(cardBody);
		card.add(content);

		TagUtil.out(getJspContext(), card);

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

}