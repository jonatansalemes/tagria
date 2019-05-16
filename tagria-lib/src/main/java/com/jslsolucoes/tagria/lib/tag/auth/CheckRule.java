package com.jslsolucoes.tagria.lib.tag.auth;

public class CheckRule {

	private String uri;
	private String method;

	public CheckRule(String uri, String method) {
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
