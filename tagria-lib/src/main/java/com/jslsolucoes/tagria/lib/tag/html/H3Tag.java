package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.H3;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class H3Tag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		H3 h3 = new H3();
		h3.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), h3);
	}

}