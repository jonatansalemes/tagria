package com.jslsolucoes.tagria.lib.v4.handler.impl;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Resources;
import com.jslsolucoes.tagria.config.v4.TagriaConfig;
import com.jslsolucoes.tagria.config.v4.xml.TagriaXML;
import com.jslsolucoes.tagria.lib.v4.handler.ResourceHandler;
import com.jslsolucoes.tagria.lib.v4.servlet.HttpHeader;

public class ContentResourceHandler implements ResourceHandler {

    private static Logger logger = LoggerFactory.getLogger(ContentResourceHandler.class);

    @Override
    public Boolean accepts(HttpServletRequest httpServletRequest) {
	return true;
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

	TagriaXML tagriaXML = tagriaXML();
	httpServletResponse.setCharacterEncoding(encoding(tagriaXML));
	httpServletResponse.setContentType(contentType(httpServletRequest));
	httpServletResponse.setHeader("Content-Encoding", "gzip");
	if (cdnIsEnabled(tagriaXML)) {
	    httpServletResponse.setHeader(HttpHeader.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
	}
	httpServletResponse.setHeader(HttpHeader.ETAG, etag(httpServletRequest));
	httpServletResponse.setHeader(HttpHeader.CACHE_CONTROL,"public,max-age=" + 31536000);
	
	String uri = uri(httpServletRequest);
	String url = "com/jslsolucoes" + uri.replaceFirst(httpServletRequest.getContextPath(), "").replaceAll(";jsessionid=.*", "");
	
	try (OutputStream outputStream = new GZIPOutputStream(httpServletResponse.getOutputStream())) {
	    byte[] resource = Resources.toByteArray(Resources.getResource(url));
	    httpServletResponse.setContentLength(resource.length);
	    outputStream.write(resource);
	} catch (Exception exception) {
	    logger.error("Could not load resource {}, {}", uri, exception);
	    httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}
    }

    private String etag(HttpServletRequest httpServletRequest) {
	return DigestUtils.sha512Hex(httpServletRequest.getRequestURL().toString());
    }

    private boolean cdnIsEnabled(TagriaXML tagriaXML) {
	return tagriaXML.getCdn().getEnabled();
    }

    private String encoding(TagriaXML tagriaXML) {
	return tagriaXML.getEncoding();
    }

    private TagriaXML tagriaXML() {
	return TagriaConfig.newConfig().xml();
    }

    private String uri(HttpServletRequest httpServletRequest) {
	return httpServletRequest.getRequestURI();
    }

    private String contentType(HttpServletRequest httpServletRequest) {
	String uri = uri(httpServletRequest);
	if (uri.endsWith(".css")) {
	    return "text/css";
	} else if (uri.endsWith(".js")) {
	    return "text/javascript";
	} else if (uri.endsWith(".png")) {
	    return "image/png";
	} else {
	    return "octect-stream";
	}
    }

}
