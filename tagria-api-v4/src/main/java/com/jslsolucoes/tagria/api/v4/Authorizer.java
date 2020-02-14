package com.jslsolucoes.tagria.api.v4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Authorizer {
    public Boolean isAllowed(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String uri,
	    String httpMethod);
}
