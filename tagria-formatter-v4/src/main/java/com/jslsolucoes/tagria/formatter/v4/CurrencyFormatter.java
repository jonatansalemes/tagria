package com.jslsolucoes.tagria.formatter.v4;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CurrencyFormatter implements Formatter {

    @Override
    public String format(String type, String value, Locale locale) {
	DecimalFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(locale));
	return nf.format(new Double(value));
    }

    @Override
    public Boolean accepts(String type) {
	return "currency".equals(type);
    }

}
