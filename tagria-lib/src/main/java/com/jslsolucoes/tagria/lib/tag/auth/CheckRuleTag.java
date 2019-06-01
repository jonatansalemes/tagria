package com.jslsolucoes.tagria.lib.tag.auth;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CheckRuleTag extends SimpleTagSupport {

	private String uri;
	private String method = "GET";

	@Override
	public void doTag() throws JspException, IOException {
		CheckTag checkTag = (CheckTag) findAncestorWithClass(this, CheckTag.class);
		checkTag.addRule(uri, method);
	}

}
