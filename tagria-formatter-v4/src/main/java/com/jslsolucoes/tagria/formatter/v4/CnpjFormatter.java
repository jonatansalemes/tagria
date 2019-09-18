package com.jslsolucoes.tagria.formatter.v4;

public class CnpjFormatter extends PatternFormatter {

    public CnpjFormatter() {
	super("cnpj", "%014d", "^([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})$", "$1.$2.$3/$4-$5");
    }

}
