package com.jslsolucoes.tagria.doc.v4.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslsolucoes.tagria.tag.auth.v4.Authorizer;

public class FalseAuthorizer implements Authorizer {

    @Override
    public Boolean isAllowed(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String uri,
	    String method) {
	return false;
    }

}
