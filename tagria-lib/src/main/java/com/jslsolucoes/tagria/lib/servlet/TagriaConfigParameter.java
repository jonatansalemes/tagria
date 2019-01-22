
package com.jslsolucoes.tagria.lib.servlet;

public enum TagriaConfigParameter {
	CDN_ENABLED("cdn.enabled", "false"), ENCODING("encoding", "utf-8"), CDN_URL("cdn.url"), SKIN("skin",
			"default"), LOCALE("locale", "en");
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