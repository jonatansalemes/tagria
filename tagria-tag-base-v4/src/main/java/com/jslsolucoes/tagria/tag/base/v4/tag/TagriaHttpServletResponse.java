package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class TagriaHttpServletResponse implements HttpServletResponse, AutoCloseable {

    private HttpServletResponse httpServletResponse;
    private OutputStream outputStream;
    private ServletOutputStream servletOutputStream;
    private PrintWriter printWriter;
    private String encoding;

    public TagriaHttpServletResponse(HttpServletResponse httpServletResponse, String encoding) {
	this.httpServletResponse = httpServletResponse;
	this.encoding = encoding;
	this.outputStream = new ByteArrayOutputStream();
    }

    @Override
    public String getCharacterEncoding() {
	return httpServletResponse.getCharacterEncoding();
    }

    @Override
    public String getContentType() {
	return httpServletResponse.getContentType();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
	if (servletOutputStream == null) {
	    servletOutputStream = new TagriaServletOutputStream(outputStream);
	}
	return servletOutputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {

	if (printWriter == null) {
	    printWriter = new TagriaPrintWriter(outputStream, encoding);
	}
	return printWriter;
    }

    public TagriaHttpServletResponse flush() throws IOException {
	flushBuffer();
	if (printWriter != null) {
	    printWriter.flush();
	} else if (servletOutputStream != null) {
	    servletOutputStream.flush();
	}
	return this;
    }

    public String asString() throws IOException {
	return new String(asByteArray(), encoding);
    }

    public byte[] asByteArray() throws IOException {
	return ((ByteArrayOutputStream) outputStream).toByteArray();
    }

    @Override
    public void close() throws IOException {

	if (servletOutputStream != null) {
	    servletOutputStream.close();
	}

	if (printWriter != null) {
	    printWriter.close();
	}

	if (outputStream != null) {
	    outputStream.close();
	}

    }

    @Override
    public void setCharacterEncoding(String charset) {
	httpServletResponse.setCharacterEncoding(charset);
    }

    @Override
    public void setContentLength(int len) {
	httpServletResponse.setContentLength(len);
    }

    @Override
    public void setContentLengthLong(long len) {
	httpServletResponse.setContentLengthLong(len);
    }

    @Override
    public void setContentType(String type) {
	httpServletResponse.setContentType(type);
    }

    @Override
    public void setBufferSize(int size) {
	httpServletResponse.setBufferSize(size);
    }

    @Override
    public int getBufferSize() {
	return httpServletResponse.getBufferSize();
    }

    @Override
    public void flushBuffer() throws IOException {
	httpServletResponse.flushBuffer();
    }

    @Override
    public void resetBuffer() {
	httpServletResponse.resetBuffer();
    }

    @Override
    public boolean isCommitted() {
	return httpServletResponse.isCommitted();
    }

    @Override
    public void reset() {
	httpServletResponse.reset();
    }

    @Override
    public void setLocale(Locale loc) {
	httpServletResponse.setLocale(loc);
    }

    @Override
    public Locale getLocale() {
	return httpServletResponse.getLocale();
    }

    @Override
    public void addCookie(Cookie cookie) {
	httpServletResponse.addCookie(cookie);
    }

    @Override
    public boolean containsHeader(String name) {
	return httpServletResponse.containsHeader(name);
    }

    @Override
    public String encodeURL(String url) {
	return httpServletResponse.encodeURL(url);
    }

    @Override
    public String encodeRedirectURL(String url) {
	return httpServletResponse.encodeRedirectURL(url);
    }

    @Override
    @Deprecated
    public String encodeUrl(String url) {
	return httpServletResponse.encodeUrl(url);
    }

    @Override
    @Deprecated
    public String encodeRedirectUrl(String url) {
	return httpServletResponse.encodeRedirectUrl(url);
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
	httpServletResponse.sendError(sc, msg);
    }

    @Override
    public void sendError(int sc) throws IOException {
	httpServletResponse.sendError(sc);
    }

    @Override
    public void sendRedirect(String location) throws IOException {
	httpServletResponse.sendRedirect(location);
    }

    @Override
    public void setDateHeader(String name, long date) {
	httpServletResponse.setDateHeader(name, date);
    }

    @Override
    public void addDateHeader(String name, long date) {
	httpServletResponse.addDateHeader(name, date);
    }

    @Override
    public void setHeader(String name, String value) {
	httpServletResponse.setHeader(name, value);
    }

    @Override
    public void addHeader(String name, String value) {
	httpServletResponse.addHeader(name, value);
    }

    @Override
    public void setIntHeader(String name, int value) {
	httpServletResponse.setIntHeader(name, value);
    }

    @Override
    public void addIntHeader(String name, int value) {
	httpServletResponse.addIntHeader(name, value);
    }

    @Override
    public void setStatus(int sc) {
	httpServletResponse.setStatus(sc);
    }

    @Override
    @Deprecated
    public void setStatus(int sc, String sm) {
	httpServletResponse.setStatus(sc, sm);
    }

    @Override
    public int getStatus() {
	return httpServletResponse.getStatus();
    }

    @Override
    public String getHeader(String name) {
	return httpServletResponse.getHeader(name);
    }

    @Override
    public Collection<String> getHeaders(String name) {
	return httpServletResponse.getHeaders(name);
    }

    @Override
    public Collection<String> getHeaderNames() {
	return httpServletResponse.getHeaderNames();
    }

}
