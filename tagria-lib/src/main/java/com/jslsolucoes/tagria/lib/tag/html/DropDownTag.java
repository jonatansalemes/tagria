package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class DropDownTag extends SimpleTagSupport {

	private String id;
	private String label;
	private Boolean rendered = Boolean.TRUE;
	private String state = "primary";
	private String size;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Div dropDown = new Div();
			dropDown.attribute(HtmlAttribute.CLASS, "dropdown");

			Button button = new Button();
			button.attribute(HtmlAttribute.TYPE, "button");
			button.attribute(HtmlAttribute.ID, TagUtil.getId(id, this));
			button.attribute(HtmlAttribute.CLASS, "btn btn-outline-" + state + " shadow-sm dropdown-toggle");
			button.attribute(HtmlAttribute.DATA_TOGGLE, "dropdown");
			if (!StringUtils.isEmpty(size)) {
				button.attribute(HtmlAttribute.CLASS, "btn-" + size);
			}

			button.add(TagUtil.getLocalized(label, getJspContext()));

			dropDown.add(button);

			Div div = new Div();
			div.attribute(HtmlAttribute.CLASS, "dropdown-menu");
			div.add(TagUtil.getBody(getJspBody()));
			dropDown.add(div);

			TagUtil.out(getJspContext(), dropDown);
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}