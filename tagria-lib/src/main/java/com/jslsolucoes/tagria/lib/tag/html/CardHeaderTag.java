
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardHeaderTag extends SimpleTagSupport {

	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		div.add(Attribute.CLASS, "card-header");
		if (!StringUtils.isEmpty(label)) {
			div.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			div.add(TagUtil.getBody(getJspBody()));
		}
		TagUtil.out(getJspContext(), div);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
