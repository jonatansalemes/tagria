package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

public class TagriaHttpServletRequest implements HttpServletRequest {
    private HttpServletRequest httpServletRequest;

    public TagriaHttpServletRequest(HttpServletRequest httpServletRequest) {
	this.httpServletRequest = httpServletRequest;
    }

    @Override
    public Object getAttribute(String name) {
	return httpServletRequest.getAttribute(name);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
	return httpServletRequest.getAttributeNames();
    }

    @Override
    public String getCharacterEncoding() {
	return httpServletRequest.getCharacterEncoding();
    }

    @Override
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
	httpServletRequest.setCharacterEncoding(env);
    }

    @Override
    public int getContentLength() {
	return httpServletRequest.getContentLength();
    }

    @Override
    public long getContentLengthLong() {
	return httpServletRequest.getContentLengthLong();
    }

    @Override
    public String getContentType() {
	return httpServletRequest.getContentType();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
	return httpServletRequest.getInputStream();
    }

    @Override
    public String getParameter(String name) {
	return httpServletRequest.getParameter(name);
    }

    @Override
    public Enumeration<String> getParameterNames() {
	return httpServletRequest.getParameterNames();
    }

    @Override
    public String[] getParameterValues(String name) {
	return httpServletRequest.getParameterValues(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
	return httpServletRequest.getParameterMap();
    }

    @Override
    public String getProtocol() {
	return httpServletRequest.getProtocol();
    }

    @Override
    public String getScheme() {
	return httpServletRequest.getScheme();
    }

    @Override
    public String getServerName() {
	return httpServletRequest.getServerName();
    }

    @Override
    public int getServerPort() {
	return httpServletRequest.getServerPort();
    }

    @Override
    public BufferedReader getReader() throws IOException {
	return httpServletRequest.getReader();
    }

    @Override
    public String getRemoteAddr() {
	return httpServletRequest.getRemoteAddr();
    }

    @Override
    public String getRemoteHost() {
	return httpServletRequest.getRemoteHost();
    }

    @Override
    public void setAttribute(String name, Object o) {
	httpServletRequest.setAttribute(name, o);
    }

    @Override
    public void removeAttribute(String name) {
	httpServletRequest.removeAttribute(name);
    }

    @Override
    public Locale getLocale() {
	return httpServletRequest.getLocale();
    }

    @Override
    public Enumeration<Locale> getLocales() {
	return httpServletRequest.getLocales();
    }

    @Override
    public boolean isSecure() {
	return httpServletRequest.isSecure();
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
	return httpServletRequest.getRequestDispatcher(path);
    }

    @Override
    @Deprecated
    public String getRealPath(String path) {
	return httpServletRequest.getRealPath(path);
    }

    @Override
    public int getRemotePort() {
	return httpServletRequest.getRemotePort();
    }

    @Override
    public String getLocalName() {
	return httpServletRequest.getLocalName();
    }

    @Override
    public String getLocalAddr() {
	return httpServletRequest.getLocalAddr();
    }

    @Override
    public int getLocalPort() {
	return httpServletRequest.getLocalPort();
    }

    @Override
    public ServletContext getServletContext() {
	return httpServletRequest.getServletContext();
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
	return httpServletRequest.startAsync();
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse)
	    throws IllegalStateException {
	return httpServletRequest.startAsync(servletRequest, servletResponse);
    }

    @Override
    public boolean isAsyncStarted() {
	return httpServletRequest.isAsyncStarted();
    }

    @Override
    public boolean isAsyncSupported() {
	return httpServletRequest.isAsyncSupported();
    }

    @Override
    public AsyncContext getAsyncContext() {
	return httpServletRequest.getAsyncContext();
    }

    @Override
    public DispatcherType getDispatcherType() {
	return httpServletRequest.getDispatcherType();
    }

    @Override
    public String getAuthType() {
	return httpServletRequest.getAuthType();
    }

    @Override
    public Cookie[] getCookies() {
	return httpServletRequest.getCookies();
    }

    @Override
    public long getDateHeader(String name) {
	return httpServletRequest.getDateHeader(name);
    }

    @Override
    public String getHeader(String name) {
	return httpServletRequest.getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
	return httpServletRequest.getHeaders(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
	return httpServletRequest.getHeaderNames();
    }

    @Override
    public int getIntHeader(String name) {
	return httpServletRequest.getIntHeader(name);
    }

    @Override
    public String getMethod() {
	return httpServletRequest.getMethod();
    }

    @Override
    public String getPathInfo() {
	return httpServletRequest.getPathInfo();
    }

    @Override
    public String getPathTranslated() {
	return httpServletRequest.getPathTranslated();
    }

    @Override
    public String getContextPath() {
	return httpServletRequest.getContextPath();
    }

    @Override
    public String getQueryString() {
	return httpServletRequest.getQueryString();
    }

    @Override
    public String getRemoteUser() {
	return httpServletRequest.getRemoteUser();
    }

    @Override
    public boolean isUserInRole(String role) {
	return httpServletRequest.isUserInRole(role);
    }

    @Override
    public Principal getUserPrincipal() {
	return httpServletRequest.getUserPrincipal();
    }

    @Override
    public String getRequestedSessionId() {
	return httpServletRequest.getRequestedSessionId();
    }

    @Override
    public String getRequestURI() {
	return httpServletRequest.getRequestURI();
    }

    @Override
    public StringBuffer getRequestURL() {
	return httpServletRequest.getRequestURL();
    }

    @Override
    public String getServletPath() {
	return httpServletRequest.getServletPath();
    }

    @Override
    public HttpSession getSession(boolean create) {
	return httpServletRequest.getSession(create);
    }

    @Override
    public HttpSession getSession() {
	return httpServletRequest.getSession();
    }

    @Override
    public String changeSessionId() {
	return httpServletRequest.changeSessionId();
    }

    @Override
    public boolean isRequestedSessionIdValid() {
	return httpServletRequest.isRequestedSessionIdValid();
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
	return httpServletRequest.isRequestedSessionIdFromCookie();
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
	return httpServletRequest.isRequestedSessionIdFromURL();
    }

    @Override
    @Deprecated
    public boolean isRequestedSessionIdFromUrl() {
	return httpServletRequest.isRequestedSessionIdFromUrl();
    }

    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
	return httpServletRequest.authenticate(response);
    }

    @Override
    public void login(String username, String password) throws ServletException {
	httpServletRequest.login(username, password);
    }

    @Override
    public void logout() throws ServletException {
	httpServletRequest.logout();
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
	return httpServletRequest.getParts();
    }

    @Override
    public Part getPart(String name) throws IOException, ServletException {
	return httpServletRequest.getPart(name);
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
	return httpServletRequest.upgrade(handlerClass);
    }
}
