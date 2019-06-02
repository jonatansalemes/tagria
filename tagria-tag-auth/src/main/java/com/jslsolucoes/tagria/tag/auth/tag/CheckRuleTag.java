package com.jslsolucoes.tagria.tag.auth.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.jslsolucoes.tagria.base.AbstractSimpleTagSupport;

public class CheckRuleTag extends AbstractSimpleTagSupport {

	private String uri;
	private String method = "GET";

	@Override
	public void doTag() throws JspException, IOException {
		CheckTag checkTag = findAncestorWithClass(this, CheckTag.class);
		checkTag.addRule(uri, method);
	}

}
