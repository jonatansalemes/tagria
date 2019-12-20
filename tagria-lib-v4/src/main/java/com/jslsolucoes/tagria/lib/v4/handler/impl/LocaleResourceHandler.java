package com.jslsolucoes.tagria.lib.v4.handler.impl;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import com.jslsolucoes.tagria.lib.v4.handler.ResourceHandler;

public class LocaleResourceHandler implements ResourceHandler {

    @Override
    public Boolean accepts(HttpServletRequest httpServletRequest) {
	return httpServletRequest.getRequestURI().endsWith("locale");
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
	Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE,
		Locale.forLanguageTag(httpServletRequest.getParameter("locale")));
	httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
