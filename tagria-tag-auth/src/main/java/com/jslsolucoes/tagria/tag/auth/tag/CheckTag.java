
package com.jslsolucoes.tagria.tag.auth.tag;

import java.util.ArrayList;
import java.util.List;

import com.jslsolucoes.tagria.base.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.auth.model.AuthRule;

public class CheckTag extends AbstractSimpleTagSupport {

	private String uri;
	private String method = "GET";
	private List<AuthRule> rules = new ArrayList<AuthRule>();

	
	@Override
	public String html() {
		String body = body();
		if (!StringUtils.isEmpty(uri)) {
			addRule(uri, method);
		}
		if (allowed()) {
			super.doTag();
		}
		return body;
	}

	public void addRule(String uri, String method) {
		rules.add(new AuthRule(uri, method));
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

	public List<AuthRule> getRules() {
		return rules;
	}

	public void setRules(List<AuthRule> rules) {
		this.rules = rules;
	}
	
	
	public Boolean allowed() {
		/*
		return rules.stream().map(authRule -> auth.allowed(httpServletRequest(),
				httpServletResponse(), authRule.getUri(), authRule.getMethod())).reduce((a, b) -> a && b)
				.get();
		*/
		return true;
	}

}
