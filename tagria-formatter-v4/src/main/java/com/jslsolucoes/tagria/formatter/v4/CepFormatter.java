package com.jslsolucoes.tagria.formatter.v4;

public class CepFormatter extends PatternFormatter {

    public CepFormatter() {
	super("cep", "%08d", "^([0-9]{5})([0-9]{3})$", "$1-$2");
    }

}
