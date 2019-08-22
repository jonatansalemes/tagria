package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class AutoCompleteItemTag extends SimpleTagSupport {
	
	private String value;
	private String text;

	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		div.add(Attribute.ID, TagUtil.getId(this));
		div.add(Attribute.CLASS,"p-2 border-top border-secondary autocomplete-item");
		div.add(Attribute.DATA_VALUE,value);
		div.add(Attribute.DATA_TEXT,text);
		div.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), div);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
