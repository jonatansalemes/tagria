
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ButtonGroupTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		Div buttonGroup = new Div();
		buttonGroup.attribute(HtmlAttribute.CLASS, "btn-group");
		buttonGroup.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), buttonGroup);
	}
}
