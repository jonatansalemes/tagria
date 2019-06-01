package com.jslsolucoes.tagria.lib.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Auth {
	public Boolean allowed(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String uri,
			String method);
}
