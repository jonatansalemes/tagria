package com.jslsolucoes.tagria.tag.auth.model;

public class AuthRule {

	private String uri;
	private String method;

	public AuthRule(String uri, String method) {
		this.uri = uri;
		this.method = method;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
