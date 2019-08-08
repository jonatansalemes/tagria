package com.jslsolucoes.tagria.lib.v4.handler.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlankResourceHandler extends DefaultResourceHandler {

	public BlankResourceHandler(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		super(httpServletRequest, httpServletResponse);
	}

	public Boolean accepts() {
		return uri().endsWith("blank");
	}

	@Override
	public void handle() {
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
	}
}
