package com.jslsolucoes.tagria.tag.auth.v4.tag;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class AuthRuleTag extends AbstractSimpleTagSupport {

	private String uri;
	private String method = "GET";

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(AuthRulesTag.class).add(new AuthRule(uri, method));
	}

	public String getUri() {
	    return uri;
	}

	public void setUri(String uri) {
	    this.uri = uri;
	}

	public String getMethod() {
	    return method;
	}

	public void setMethod(String method) {
	    this.method = method;
	}

}
