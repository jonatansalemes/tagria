package com.jslsolucoes.tagria.tag.auth.tag;

import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class AuthRuleTag extends AbstractSimpleTagSupport {

	private String uri;
	private String method = "GET";

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(AuthRulesTag.class).add(new AuthRule(uri, method));
	}

}
