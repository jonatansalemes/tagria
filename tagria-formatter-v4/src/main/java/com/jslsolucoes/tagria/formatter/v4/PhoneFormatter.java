package com.jslsolucoes.tagria.formatter.v4;

public class PhoneFormatter extends PatternFormatter {

    public PhoneFormatter() {
	super("tel", "%010d", "^([0-9]{2})([0-9]{4,5})([0-9]{4})$", "($1) $2-$3");
    }

}
