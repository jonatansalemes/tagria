package com.jslsolucoes.tagria.formatter.v4;

import java.util.Locale;

public abstract class PatternFormatter implements Formatter {

    private String accepts;
    private String pattern;
    private String replace;
    private String format;

    public PatternFormatter(String accepts, String format, String pattern, String replace) {
	this.accepts = accepts;
	this.format = format;
	this.pattern = pattern;
	this.replace = replace;
    }

    @Override
    public String format(String type, String value, Locale locale) {
	return String.format(format, Long.valueOf(value)).replaceAll(pattern, replace);
    }

    @Override
    public Boolean accepts(String type) {
	return accepts.equals(type);
    }

}
