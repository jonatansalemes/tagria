
package com.jslsolucoes.tagria.lib.servlet;

public enum HttpHeaderParameter {
	ETAG("Etag"), CACHE_CONTROL("Cache-Control"), EXPIRES("Expires"), ACCESS_CONTROL_ALLOW_ORIGIN(
			"Access-Control-Allow-Origin");

	private String name;

	private HttpHeaderParameter(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
