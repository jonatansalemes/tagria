package com.jslsolucoes.tagria.tag.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultAuthorizer implements Authorizer {

	@Override
	public Boolean isAllowed(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String uri,
			String method) {
		return true;
	}

}
