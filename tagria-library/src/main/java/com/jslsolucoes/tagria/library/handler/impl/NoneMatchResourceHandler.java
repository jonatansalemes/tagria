package com.jslsolucoes.tagria.library.handler.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class NoneMatchResourceHandler extends DefaultResourceHandler {

	public NoneMatchResourceHandler(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		super(httpServletRequest, httpServletResponse);
	}

	@Override
	public Boolean accepts() {
		String ifNoneMatch = header("If-None-Match");
		return (!StringUtils.isAllEmpty(ifNoneMatch) && etag().equals(ifNoneMatch));
	}

	@Override
	public void handle() {
		httpServletResponse.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
	}

}
