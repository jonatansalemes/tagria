
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.H5;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CollapsableTag extends SimpleTagSupport {

	private String label;
	private Boolean opened = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {

		Div card = new Div();
		card.attribute(HtmlAttribute.CLASS, "card");
		card.attribute(HtmlAttribute.ID, TagUtil.getId(this));

		Div cardHeader = new Div();
		cardHeader.attribute(HtmlAttribute.CLASS, "card-header");
		H5 h5 = new H5();
		h5.attribute(HtmlAttribute.CLASS, "mb-0");

		String idTarget = TagUtil.getId(this);
		Button button = new Button();
		button.attribute(HtmlAttribute.CLASS, "btn btn-link");
		button.attribute(HtmlAttribute.DATA_TOGGLE, "collapse");
		button.attribute(HtmlAttribute.DATA_TARGET, "#" + idTarget);
		button.attribute(HtmlAttribute.ID, TagUtil.getId(this));
		button.add(TagUtil.getLocalized(label, getJspContext()));
		h5.add(button);

		cardHeader.add(h5);

		card.add(cardHeader);

		Div content = new Div();
		content.attribute(HtmlAttribute.ID, idTarget);
		content.attribute(HtmlAttribute.CLASS, "collapse " + (opened ? "show" : ""));

		Div cardBody = new Div();
		cardBody.attribute(HtmlAttribute.CLASS, "card-body");
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