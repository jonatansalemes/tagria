
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.H2;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class H2Tag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		H2 h2 = new H2();
		h2.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), h2);
	}

}
