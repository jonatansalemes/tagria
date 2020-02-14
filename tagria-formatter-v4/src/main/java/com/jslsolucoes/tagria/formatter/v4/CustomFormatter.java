package com.jslsolucoes.tagria.formatter.v4;

import java.util.Locale;

public class CustomFormatter implements Formatter {

    private String accepts;
    private String match;
    private String replace;

    public CustomFormatter(String accepts, String match, String replace) {
	this.accepts = accepts;
	this.match = match;
	this.replace = replace;
    }

    @Override
    public String format(String type, String value, Locale locale) {
	return value.replaceAll(match, replace);
    }

    @Override
    public Boolean accepts(String type) {
	return accepts.equals(type);
    }

}
