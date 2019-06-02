package com.jslsolucoes.tagria.tag.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultTagriaAuth implements TagriaAuth {

	@Override
	public Boolean allowed(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String uri,
			String method) {
		return true;
	}

}
