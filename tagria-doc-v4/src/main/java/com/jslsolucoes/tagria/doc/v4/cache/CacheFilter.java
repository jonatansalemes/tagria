package com.jslsolucoes.tagria.doc.v4.cache;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.jslsolucoes.tagria.lib.v4.servlet.HttpHeader;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.base.v4.tag.TagriaServletResponseWrapper;

public class CacheFilter implements Filter {

    private Cache<String, byte[]> cache = CacheBuilder.newBuilder().build();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	    throws IOException, ServletException {
	HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
	HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
	 String key = httpServletRequest.getRequestURI();
	if (!skip(key)) {
	   
	    String version = AbstractSimpleTagSupport.VERSION;
	    String etag = DigestUtils.sha256Hex(key + version);
	    if (etag.equals(httpServletRequest.getHeader("If-None-Match"))) {
		httpServletResponse.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
	    } else {
		byte[] response = cache.getIfPresent(key);
		if (response == null) {
		    try (TagriaServletResponseWrapper tagriaServletResponseWrapper = new TagriaServletResponseWrapper(
			    httpServletResponse, "utf-8")) {

			LocalDateTime now = LocalDateTime.now();
			LocalDateTime expires = LocalDateTime.now().plusDays(365);
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
			tagriaServletResponseWrapper.setHeader(HttpHeader.LAST_MODIFIED, dateTimeFormatter.format(now));
			tagriaServletResponseWrapper.setHeader(HttpHeader.EXPIRES, dateTimeFormatter.format(expires));
			tagriaServletResponseWrapper.setHeader(HttpHeader.CACHE_CONTROL,"public,max-age=" + now.until(expires, ChronoUnit.SECONDS));
			tagriaServletResponseWrapper.setHeader(HttpHeader.ETAG,etag);
			filterChain.doFilter(httpServletRequest, tagriaServletResponseWrapper);
			response = tagriaServletResponseWrapper.flush().asByteArray();
			cache.put(key, response);
		    }
		}
		httpServletResponse.getOutputStream().write(response);
	    }
	} else {
	    filterChain.doFilter(servletRequest, servletResponse);
	}

    }

    private boolean skip(String key) {
	return Arrays.asList(".css",".js",".png",".ico","/app/playground").stream().anyMatch(extension -> key.endsWith(extension));
    }
}
