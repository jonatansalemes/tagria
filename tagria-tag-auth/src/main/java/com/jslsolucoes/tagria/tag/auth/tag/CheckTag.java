
package com.jslsolucoes.tagria.tag.auth.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.base.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.base.config.TagriaConfigParameter;
import com.jslsolucoes.tagria.exception.TagriaRuntimeException;
import com.jslsolucoes.tagria.tag.auth.TagriaAuth;
import com.jslsolucoes.tagria.tag.auth.model.AuthRule;

public class CheckTag extends AbstractSimpleTagSupport {

	private String uri;
	private String method = "GET";
	private List<AuthRule> rules = new ArrayList<AuthRule>();
	
	@Override
	public void doTag() throws JspException, IOException {
		String body = body();
		if (!StringUtils.isEmpty(uri)) {
			addRule(uri, method);
		}
		if (allowed()) {
			print(body);
		}
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

	public TagriaAuth tagriaAuth() {
		try {
			return (TagriaAuth) Class.forName(getInitParam(TagriaConfigParameter.AUTH_CLASS)).newInstance();
		} catch (Exception e) {
			throw new TagriaRuntimeException(e);
		}
	}

	public Boolean allowed() {
		return rules.stream().map(authRule -> tagriaAuth().allowed(httpServletRequest(), httpServletResponse(),
				authRule.getUri(), authRule.getMethod())).reduce((a, b) -> a && b).get();
	}

}
