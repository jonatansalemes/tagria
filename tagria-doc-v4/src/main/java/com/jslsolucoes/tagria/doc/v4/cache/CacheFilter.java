package com.jslsolucoes.tagria.doc.v4.cache;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.jslsolucoes.tagria.tag.base.v4.tag.TagriaResponseWrapper;

public class CacheFilter implements Filter {

    private final static Boolean CACHE_RESOURCE = Boolean.FALSE;
    private Cache<String,byte[]> cache = CacheBuilder.newBuilder().build();
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	    throws IOException, ServletException {
	HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
	HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
	String key = httpServletRequest.getRequestURI();
	byte[] response = cache.getIfPresent(key);
	if(response == null) {
	    try(TagriaResponseWrapper tagriaResponseWrapper = new TagriaResponseWrapper(httpServletResponse)){
		filterChain.doFilter(httpServletRequest, tagriaResponseWrapper);
		response = tagriaResponseWrapper.asBytes();
		if(CACHE_RESOURCE) cache.put(key,response);
	    }
	}
	httpServletResponse.getOutputStream().write(response);
    }

}
