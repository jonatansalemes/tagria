package com.jslsolucoes.tagria.doc.v4.formatter;

import java.util.Locale;

import com.jslsolucoes.tagria.formatter.v4.Formatter;

public class MyFormatter implements Formatter {

    @Override
    public Boolean accepts(String type) {
	return "matriculaSap".equals(type);
    }

    @Override
    public String format(String type, String value, Locale locale) {
	return "matriculaSap";
    }

}
