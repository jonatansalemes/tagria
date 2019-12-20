package com.jslsolucoes.tagria.lib.v4.handler.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslsolucoes.tagria.lib.v4.handler.ResourceHandler;

public class BlankResourceHandler implements ResourceHandler {

    @Override
    public Boolean accepts(HttpServletRequest httpServletRequest) {
	return httpServletRequest.getRequestURI().endsWith("blank");
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
	httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
