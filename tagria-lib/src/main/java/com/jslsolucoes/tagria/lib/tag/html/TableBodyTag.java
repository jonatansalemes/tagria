
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Tbody;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableBodyTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		Tbody tbody = new Tbody();
		tbody.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), tbody);
	}

}
