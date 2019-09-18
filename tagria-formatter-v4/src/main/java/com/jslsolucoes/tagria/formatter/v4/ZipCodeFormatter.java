package com.jslsolucoes.tagria.formatter.v4;

public class ZipCodeFormatter extends PatternFormatter {

    public ZipCodeFormatter() {
	super("zipCode", "%08d", "^([0-9]{5})-([0-9]{3})$", "$1-$2");
    }

}
