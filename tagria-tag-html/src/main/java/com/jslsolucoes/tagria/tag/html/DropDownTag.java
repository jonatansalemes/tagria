package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class DropDownTag extends AbstractSimpleTagSupport {

	private String id;
	private String label;
	
	private String state = "primary";
	private String size;

	@Override
	public void render() {
		
			Div dropDown = new Div();
			dropDown.attribute(Attribute.CLASS, "dropdown");

			Button button = new Button();
			button.attribute(Attribute.TYPE, "button");
			button.attribute(Attribute.ID, TagUtil.getId(id, this));
			button.attribute(Attribute.CLASS, "btn btn-outline-" + state + " shadow-sm dropdown-toggle");
			button.attribute(Attribute.DATA_TOGGLE, "dropdown");
			if (!StringUtils.isEmpty(size)) {
				button.attribute(Attribute.CLASS, "btn-" + size);
			}

			button.add(TagUtil.getLocalized(label, getJspContext()));

			dropDown.add(button);

			Div div = new Div();
			div.attribute(Attribute.CLASS, "dropdown-menu");
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