package com.jslsolucoes.tagria.lib.v4.handler.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.tagria.config.v4.TagriaConfig;
import com.jslsolucoes.tagria.config.v4.xml.TagriaXML;
import com.jslsolucoes.tagria.lib.v4.servlet.HttpHeader;

public class ContentResourceHandler extends DefaultResourceHandler {

    private static Logger logger = LoggerFactory.getLogger(ContentResourceHandler.class);

    public ContentResourceHandler(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
	super(httpServletRequest, httpServletResponse);
    }

    @Override
    public Boolean accepts() {
	return true;
    }

    @Override
    public void handle() {
	setCharset();
	setContentType();
	setContentEncoding();
	setAllowOrigin();
	setEtag();
	setExpires();
	setContent();
    }

    private void setCharset() {
	httpServletResponse
		.setCharacterEncoding(xml().getEncoding());
    }

    private void setContent() {
	String uri = uri();
	String url = "/com/jslsolucoes" + uri.replaceFirst(httpServletRequest.getContextPath(), "").replaceAll(";jsessionid=.*", "");
	try (OutputStream outputStream = new GZIPOutputStream(outputStream());
		InputStream in = getClass().getResourceAsStream(url)) {
	    setContentLength(in.available());
	    byte[] buffer = new byte[1024 * 10];
	    int nByteRead = 0;
	    while ((nByteRead = in.read(buffer)) != -1) {
		outputStream.write(buffer, 0, nByteRead);
	    }
	} catch (Exception exception) {
	    logger.error("Could not load resource {}, {}", uri, exception);
	    httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}
    }
    
    private TagriaXML xml() {
	return TagriaConfig.newConfig().xml();
    }

    private void setAllowOrigin() {
	if (xml().getCdn().getEnabled()) {
	    httpServletResponse.setHeader(HttpHeader.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
	}
    }

    private void setContentLength(Integer contentLength) {
	httpServletResponse.setContentLength(contentLength);
    }

    private void setContentEncoding() {
	httpServletResponse.setHeader("Content-Encoding","gzip");
    }

    private void setContentType() {
	String uri = uri();
	if (uri.endsWith(".css")) {
	    httpServletResponse.setContentType("text/css");
	} else if (uri.endsWith(".js")) {
	    httpServletResponse.setContentType("text/javascript");
	} else if (uri.endsWith(".png")) {
	    httpServletResponse.setContentType("image/png");
	}
    }

    private void setEtag() {
	httpServletResponse.setHeader(HttpHeader.ETAG, etag());
    }

    private void setExpires() {
	LocalDateTime now = LocalDateTime.now();
	LocalDateTime expires = LocalDateTime.now().plusDays(365);
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss 'GMT'",
		Locale.ENGLISH);
	httpServletResponse.setHeader(HttpHeader.EXPIRES, dateTimeFormatter.format(expires));
	httpServletResponse.setHeader(HttpHeader.CACHE_CONTROL,
		"public,max-age=" + now.until(expires, ChronoUnit.SECONDS));
    }

}
