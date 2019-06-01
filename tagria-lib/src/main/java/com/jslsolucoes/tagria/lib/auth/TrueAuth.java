package com.jslsolucoes.tagria.lib.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrueAuth implements Auth {

	@Override
	public Boolean allowed(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String uri,
			String method) {
		return true;
	}

}
