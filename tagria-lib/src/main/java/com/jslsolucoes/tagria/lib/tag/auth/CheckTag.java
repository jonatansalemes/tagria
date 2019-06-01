
package com.jslsolucoes.tagria.lib.tag.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CheckTag extends SimpleTagSupport {

	private String uri;
	private String method = "GET";
	private List<CheckRule> rules = new ArrayList<CheckRule>();

	@Override
	public void doTag() throws JspException, IOException {
		String body = TagUtil.getBody(getJspBody());
		if (!StringUtils.isEmpty(uri))
			addRule(uri, method);
		if (TagUtil.allowed(getJspContext(), rules)) {
			TagUtil.out(getJspContext(), body);
		}
	}

	public void addRule(String uri, String method) {
		rules.add(new CheckRule(uri, method));
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

	public List<CheckRule> getRules() {
		return rules;
	}

	public void setRules(List<CheckRule> rules) {
		this.rules = rules;
	}

}
