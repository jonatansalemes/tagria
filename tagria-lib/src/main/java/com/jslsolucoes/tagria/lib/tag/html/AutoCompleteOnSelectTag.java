
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class AutoCompleteOnSelectTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		AutoCompleteTag autoCompleteTag = (AutoCompleteTag) findAncestorWithClass(this, AutoCompleteTag.class);
		autoCompleteTag.setOnSelect(TagUtil.getBody(getJspBody()));
	}
}
