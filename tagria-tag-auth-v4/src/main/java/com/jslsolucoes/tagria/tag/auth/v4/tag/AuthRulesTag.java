
package com.jslsolucoes.tagria.tag.auth.v4.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslsolucoes.tagria.config.v4.TagriaConfig;
import com.jslsolucoes.tagria.config.v4.TagriaConfigParameter;
import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.auth.v4.Authorizer;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class AuthRulesTag extends AbstractSimpleTagSupport {

	private List<AuthRule> authRules = new ArrayList<AuthRule>();

	@Override
	public Element render() {
		return ElementCreator.newCData(bodyContent());
	}

	@Override
	public Boolean rendered() {
		return super.rendered() && allowed();
	}
	
	@Override
	public Boolean flush() {
		return true;
	}

	public void add(AuthRule authRule) {
		authRules.add(authRule);
	}

	private Authorizer authorizer() {
		try {
			return (Authorizer) Class.forName(TagriaConfig.newConfig().propertyValue(TagriaConfigParameter.AUTH_CLASS))
					.newInstance();
		} catch (Exception e) {
			throw new TagriaRuntimeException(e);
		}
	}

	private Boolean allowed() {
		Authorizer authorizer = authorizer();
		HttpServletRequest httpServletRequest = httpServletRequest();
		HttpServletResponse httpServletResponse = httpServletResponse();
		return authRules.stream().map(authRule -> authorizer.isAllowed(httpServletRequest, httpServletResponse,
				authRule.getUri(), authRule.getMethod())).reduce((a, b) -> a && b).get();
	}

}
