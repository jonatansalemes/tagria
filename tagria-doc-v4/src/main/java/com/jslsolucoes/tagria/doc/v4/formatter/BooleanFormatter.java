package com.jslsolucoes.tagria.doc.v4.formatter;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.formatter.v4.Formatter;

public class BooleanFormatter implements Formatter {

    @Override
    public String format(String type, String value, Locale locale) {
	if(!StringUtils.isEmpty(value)) {
	    if("1".equals(value) || "true".equals(value)) {
		return "Sim";
	    } else if("0".equals(value) || "false".equals(value)) {
		return "Não";
	    } else {
		return value;
	    }
	}
	return null;
    }

    @Override
    public Boolean accepts(String type) {
	return "boolean".equals(type);
    }

}
