package com.jslsolucoes.tagria.tag.security.v4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslsolucoes.tagria.api.v4.Authorizer;

public class DefaultAuthorizer implements Authorizer {

    @Override
    public Boolean isAllowed(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String uri,
	    String method) {
	return true;
    }

}
