package com.jslsolucoes.tagria.lib.v4.handler.impl;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

public class LocaleResourceHandler extends DefaultResourceHandler {

	public LocaleResourceHandler(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		super(httpServletRequest, httpServletResponse);
	}

	@Override
	public Boolean accepts() {
		return uri().endsWith("locale");
	}

	@Override
	public void handle() {
		setLocale();
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
	}

	private void setLocale() {
		Config.set(httpServletRequest.getSession(), Config.FMT_LOCALE, Locale.forLanguageTag(parameter("locale")));
	}

}
