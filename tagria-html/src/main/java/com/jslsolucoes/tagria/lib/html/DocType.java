
package com.jslsolucoes.tagria.lib.html;

public enum DocType {

	HTML5("<!DOCTYPE html>");

	private String definition;

	private DocType(String definition) {
		this.definition = definition;
	}

	public String definition() {
		return definition;
	}

}
