
package com.jslsolucoes.tagria.config.v4;

public enum TagriaConfigParameter {
	CDN_ENABLED("cdn.enabled", "false"), ENCODING("encoding", "utf-8"), CDN_URL("cdn.url"), SKIN("skin", "default"),
	LOCALE("locale", "en"), AUTH_CLASS("auth.class", "com.jslsolucoes.tagria.tag.auth.v4.DefaultAuthorizer");
	private String name;
	private String defaultValue;

	private TagriaConfigParameter(String name, String defaultValue) {
		this.name = name;
		this.defaultValue = defaultValue;
	}

	private TagriaConfigParameter(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

}