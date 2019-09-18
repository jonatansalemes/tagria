package com.jslsolucoes.tagria.formatter.v4;

public class CpfFormatter extends PatternFormatter {

    public CpfFormatter() {
	super("cpf", "%011d", "^([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})$", "$1.$2.$3-$4");
    }

}
