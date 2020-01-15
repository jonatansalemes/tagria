package com.jslsolucoes.tagria.lib.v4.handler.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.lib.v4.handler.ResourceHandler;
import com.jslsolucoes.tagria.lib.v4.servlet.HttpHeader;

public class CacheableResourceHandler implements ResourceHandler {

    @Override
    public Boolean accepts(HttpServletRequest httpServletRequest) {
	String etag = httpServletRequest.getHeader(HttpHeader.IF_NONE_MATCH);
	return (!StringUtils.isEmpty(etag)
		&& etag
			.equals(etag(httpServletRequest)));
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
	httpServletResponse.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
    }
    
    private String etag(HttpServletRequest httpServletRequest) {
	return DigestUtils.sha512Hex(httpServletRequest.getRequestURL().toString());
    }

}
