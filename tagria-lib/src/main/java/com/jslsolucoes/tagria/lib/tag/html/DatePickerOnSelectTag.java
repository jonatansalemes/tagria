
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class DatePickerOnSelectTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder builder = new StringBuilder();
		builder.append(",onSelect : function(dateText,inst){");
		builder.append(TagUtil.getBody(getJspBody()));
		builder.append("}");
		TagUtil.out(getJspContext(), builder.toString());
	}
}
