
package com.jslsolucoes.tagria.html.v4;

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
