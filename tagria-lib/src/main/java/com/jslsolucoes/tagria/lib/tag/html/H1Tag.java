package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.H1;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class H1Tag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		H1 h1 = new H1();
		h1.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), h1);
	}

}