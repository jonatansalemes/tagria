package com.jslsolucoes.tagria.library.handler.impl;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.jslsolucoes.tagria.library.handler.ResourceHandler;

public abstract class DefaultResourceHandler implements ResourceHandler {

	protected HttpServletRequest httpServletRequest;
	protected HttpServletResponse httpServletResponse;

	public DefaultResourceHandler(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		this.httpServletRequest = httpServletRequest;
		this.httpServletResponse = httpServletResponse;
	}

	public String etag() {
		return DigestUtils.sha512Hex(uri());
	}

	public String uri() {
		return httpServletRequest.getRequestURI().replaceAll(";jsessionid=.*", "");
	}

	public String header(String headerName) {
		return httpServletRequest.getHeader(headerName);
	}

	public String parameter(String parameterName) {
		return httpServletRequest.getParameter(parameterName);
	}

	public OutputStream outputStream() throws IOException {
		return httpServletResponse.getOutputStream();
	}
}
